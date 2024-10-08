package com.example.clothme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.clothme.Adapter.SpinnerAdapter;
import com.example.clothme.Database.ClothesDB;
import com.example.clothme.Models.ClothesModel;

import java.io.File;
import java.util.Arrays;

import yuku.ambilwarna.AmbilWarnaDialog;

public class View_Wardrobe extends AppCompatActivity {
    Spinner type,fabric,pattern;
    String newType,newColor,newFabric,newPattern;
    Button cancel,update,pickColor;
    ImageView im;
    ClothesModel cm;
//    String[] TypeCat = new String[]{"Blazers","Cardigans","Jumpsuits","Tracksuits","T-Shirts","Tops","Shirts","Long Sleeves Shirt",
//            "Innerwear Vests","Tank Tops","Hoodies","Suits","Shirt","Dresses","Gowns","Coats","Sherwanis","Jackets","Sweaters",
//            "Sweatshirts","Vests","Pajama","Capri & Cropped Pants","Track Pants","Jeans","Tights","Shorts","Skirts","Lounge Pants","Trousers","Pants","Leggings"};
    String[]TypeCatMale=new String[]{"Pajama","Shirt","Shorts","Track Pants","Sweaters","T-Shirt","Lounge Pants","Innerwear Vests","Jacket"
            ,"Trousers","Tracksuits","Long Sleeves Shirt","Blazer","Jeans","Coat"};
    String[] TypeCatFemale=new String[]{"Skirt","Sweater","Tank Top","Jacket","Tights","Dresses","Blazer","Shorts","Capri & Cropped Pants",
            "Gown","Cardigans","Top","Jeans","Hoodies","Shirt","Suits","Pants","Vests","Coat","Jumpsuits","Sweatshirt","T-Shirt","Leggings","Coat"
            ,"Hoodies","Long Dress","Long Sleeved Dress","Long Sleeves Shirt","Pencil Skirt","Shawl","Short Dress","Short Sleeveless Dress"
            ,"Short skirt","Sleeveless Top","Track Pants","Track Suit"};


    String[] FabricCat = new String[]{"Cotton", "Wool", "Nylon/Polyester", "Silk"};
    String[] ColorCat = new String[]{"NULL","MediumOrchid","PaleGoldenRod","Black","DarkSeaGreen","LightSlateGray","Sienna","Gainsboro","LightCoral","Orange","DarkSlateGray",
            "DodgerBlue","Aquamarine","LightSeaGreen","Beige","RoyalBlue","DarkViolet","MediumSlateBlue","OliveDrab","MidnightBlue","SandyBrown","Violet",
            "LimeGreen","Magenta","PowderBlue","DarkSlateBlue","DeepSkyBlue","DarkTurquoise","Chartreuse","Olive","IndianRed","LightGray","PeachPuff",
            "MediumPurple","Yellow","LightBlue","Indigo","SpringGreen","DarkRed","Peru","Wheat","RosyBrown","MediumAquaMarine","DarkCyan","FireBrick",
            "LawnGreen","OrangeRed","DarkOrange","Teal","Turquoise","SeaShell","HoneyDew","Maroon","Cyan","Blue","Moccasin","Chocolate","WhiteSmoke",
            "LightGoldenRodYellow","MediumSeaGreen","SeaGreen","Thistle","LavenderBlush","LightCyan","Red","SlateGray","MistyRose","Crimson","NavajoWhite",
            "SlateBlue","Orchid","Tan","LightSalmon","DarkGray","Snow","DarkBlue","Fuchsia","Tomato","Plum","Cornsilk","PaleGreen","YellowGreen","MintCream",
            "PaleVioletRed","DimGray","Gold","Azure","DarkOliveGreen","Gray","Salmon","LemonChiffon","FloralWhite","BlanchedAlmond","GreenYellow","Silver",
            "Khaki","Pink","Ivory","LightSkyBlue","AliceBlue","DarkGreen","DarkSalmon","PapayaWhip","Linen","LightGreen","MediumTurquoise","AntiqueWhite",
            "Brown","LightPink","OldLace","Aqua","DarkGoldenRod","Bisque","CadetBlue","BurlyWood","MediumBlue","BlueViolet","Lime","Lavender","CornflowerBlue",
            "LightSteelBlue","GhostWhite","SteelBlue","MediumSpringGreen","DarkKhaki","PaleTurquoise","ForestGreen","DarkOrchid","DeepPink","MediumVioletRed",
            "HotPink","LightYellow","Navy","SaddleBrown","White","Coral","Purple","DarkMagenta","GoldenRod","Green","SkyBlue"};

    String[] patternCat=new String[]{"plain","abstract","geometry","floral","stripes","checks"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_wardrobe);
        getSupportActionBar().hide();
        type=findViewById(R.id.typeSpinner);
        fabric=findViewById(R.id.fabricSpinner);
        pattern=findViewById(R.id.patternSpinner);
//        color=findViewById(R.id.colorSpinner);
        pickColor=findViewById(R.id.bt_pick_color);
        update=findViewById(R.id.buttonUpdate);
        cancel=findViewById(R.id.cancel);
        im=findViewById(R.id.imageViewCloth);
        Intent i=getIntent();

        ClothesDB db=new ClothesDB(this);
        cm=db.getCloth(MainActivity.user.getUsername(),i.getExtras().getString("clothId"));
        newType=cm.getClothtype();
        newColor=cm.getColor();
        newFabric=cm.getFabric();
        newPattern=cm.getPattern();
        final String path = getPathFromURI(Uri.parse(cm.getUri()));
        File f = new File(path);
        Uri uri = Uri.fromFile(f);
        im.setImageURI(uri);

//        Toast.makeText(this,""+cm.getColor(),Toast.LENGTH_SHORT).show();
        String[] TypeCat;
        String gender=MainActivity.user.getGender();
        if(gender.equals("Male")){
            TypeCat=TypeCatMale;
        }else{
            TypeCat=TypeCatFemale;
        }
        ArrayAdapter<String> typeAdapter=new ArrayAdapter<>(View_Wardrobe.this, android.R.layout.simple_spinner_dropdown_item,TypeCat);
        type.setAdapter(typeAdapter);
        int pos=Arrays.asList(TypeCat).indexOf(cm.getClothtype());
//        Toast.makeText(this,""+pos,Toast.LENGTH_SHORT).show();
        type.setSelection(pos);
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                newType=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//
        typeAdapter=new ArrayAdapter<>(View_Wardrobe.this, android.R.layout.simple_spinner_dropdown_item,FabricCat);
        fabric.setAdapter(typeAdapter);
        pos=Arrays.asList(FabricCat).indexOf(cm.getFabric());
        fabric.setSelection(pos);
        fabric.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                newFabric=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        typeAdapter=new ArrayAdapter<>(View_Wardrobe.this, android.R.layout.simple_spinner_dropdown_item,patternCat);
        pattern.setAdapter(typeAdapter);
        pos=Arrays.asList(patternCat).indexOf(cm.getPattern());
        pattern.setSelection(pos);
        pattern.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                newPattern=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        int initialColor=Color.WHITE;
        try{
            initialColor= Color.parseColor(cm.getColor());
        }catch(NullPointerException e){
            initialColor=Color.WHITE;
        }
//        = Color.parseColor(cm.getColor());
        pickColor.setBackgroundColor(initialColor);
        int finalInitialColor = initialColor;
        pickColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AmbilWarnaDialog dialog = new AmbilWarnaDialog(View_Wardrobe.this, finalInitialColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        // color is the color selected by the user.
                        String hex="#"+Integer.toHexString(color);
                        Log.v("AAA",hex);
                        newColor=hex;
                        pickColor.setBackgroundColor(color);
                    }

                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                        // cancel was selected by the user
                    }
                });
                dialog.show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClothesModel cm1=new ClothesModel(cm.getUsername(),cm.getId(),cm.getUri(),newType,newColor,newFabric,null,newPattern,cm.getLastworn());
                db.updateCloth(cm1);
                setResult(RESULT_OK, null);
                finish();
            }
        });

    }
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        File image=new File(contentUri.getPath());
        res=image.getAbsolutePath();
//        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
//        if (cursor.moveToFirst()) {
//            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            res = cursor.getString(column_index);
//        }
//        cursor.close();
        return res;
    }
}