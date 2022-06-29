package com.example.clothme.Recommendation;


import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.example.clothme.Database.ClothesDB;
import com.example.clothme.MainActivity;
import com.example.clothme.Models.ClothesModel;
import com.example.clothme.Models.ImageModel;
import com.example.clothme.Models.ReturnClothLogicModelLists;

import java.util.ArrayList;
import java.util.Objects;

public class ClothLogicFemale {

    // ArrayList<String> top = new ArrayList<>();
    //ArrayList<String> bottom = new ArrayList<>();

    ArrayList<ArrayList<String>> top =
            new ArrayList<ArrayList<String>>();

    ArrayList<ArrayList<String>> bottom =
            new ArrayList<ArrayList<String>>();

    ArrayList<ArrayList<String>> outer =
            new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> toprightwear = null;
    ArrayList<ArrayList<String>> bottomrightwear = null;
    ArrayList<ArrayList<String>> outerrightwear = null;

    /*String userid = getUsername();
    String imageid = getImageid();
    String uri = getUri();
    String clothtype = getClothtype();
    String color = getColor();
    String fabric = getFabric();
    String category = getCategory();
    String rating;*/

    public int temperature;
    String occasion;
    Context context;

    private String setOccasion() {
        this.occasion = occasion;
        return occasion;
    }


    private int setTemperature() {
        this.temperature = temperature;
        return temperature;
    }


    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Context getContext() {
        return context;
    }

    //    public void setOccasion(String occasion) {
//        this.occasion = occasion;
//    }
    public ArrayList<ImageModel> convertData(ArrayList<ClothesModel> cm, int temperature, String occasion, Context context) {
        this.context = context;
        setTemperature(temperature);
        setOccasion(occasion);
//        Log.v("AAA",cm.size()+":Cl");
        for (int i = 0; i < cm.size(); i++) {
            ClothesModel cm1 = cm.get(i);
            String username = cm1.getUsername();
            String imageId = cm1.getId();
            String uri = cm1.getUri();
            String clothtype = cm1.getClothtype();
            String color = cm1.getColor();
            String fabric = cm1.getFabric();
            String category = cm1.getCategory();
            all_predict(username, uri, clothtype, color, fabric, category, "0", imageId);
        }
        ArrayList<ImageModel> images = generateOutfit(top, bottom, outer);
        return images;
    }

    public void all_predict(String userid, String uri, String clothtype, String color, String fabric, String category, String rating
            , String imageid) {
        ArrayList<String> list = new ArrayList<>();
        list.add(userid);
        list.add(imageid);
        list.add(clothtype);
        list.add(color);
        list.add(fabric);
        list.add(uri);
        list.add(rating);
        if (Objects.equals(category, "topwear")) {
            top.add(list);
        } else if (Objects.equals(category, "bottomwear")) {
            bottom.add(list);
        } else if (Objects.equals(category, "outerwear")) {
            outer.add(list);
        }
    }

    public ArrayList<ImageModel> generateOutfit(ArrayList<ArrayList<String>> top, ArrayList<ArrayList<String>> bottom, ArrayList<ArrayList<String>> outer) {
        int temperature1 = setTemperature();
        String event = setOccasion();
        toprightwear = new ArrayList<ArrayList<String>>();
        bottomrightwear = new ArrayList<ArrayList<String>>();
        outerrightwear = new ArrayList<ArrayList<String>>();
        switch (event) {
            case "religious event":

                /*TopWear*/
                if (temperature1 <= 15) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Long Dress")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 15 && temperature1 <= 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Long Dress")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 8;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Long Dress")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                }
                /*Bottom*/
                if (temperature1 < 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Pants")) {
                            if (Objects.equals(bottom.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                } else if (temperature1 >= 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Pants")) {

                            if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                }


                /*Outer*/
                if (temperature1 <= 20) {
                    for (int i = 0; i < outer.size(); i++) {
                        int number = 0;
                        if (Objects.equals(outer.get(i).get(2), "Coat")) {
                            number = number + 10;
                            String s = String.valueOf(number);
                            outer.get(i).set(6, s);
                            outerrightwear.add(outer.get(i));
                        }
                    }

                }

                break;

            case "casual/travel":
            case "picnic":
            case "barbeque":
                /*TopWear*/
                if (temperature1 <= 15) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "T-Shirt") || Objects.equals(top.get(i).get(2), "Shirt") || Objects.equals(top.get(i).get(2), "Tank Top") || Objects.equals(top.get(i).get(2), "Top")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 15 && temperature1 <= 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "T-Shirt") || Objects.equals(top.get(i).get(2), "Shirt") || Objects.equals(top.get(i).get(2), "Tank Top") || Objects.equals(top.get(i).get(2), "Top")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }

                } else if (temperature1 > 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "T-Shirt") || Objects.equals(top.get(i).get(2), "Shirt") || Objects.equals(top.get(i).get(2), "Tank Top") || Objects.equals(top.get(i).get(2), "Top")) {
                            if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }
                    }


                }

                /*Bottom*/
                if (temperature1 <= 25) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Jeans") || Objects.equals(bottom.get(i).get(2), "Leggings")) {
                            if (Objects.equals(bottom.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }
                    }

                } else if (temperature1 > 25) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Jeans") || Objects.equals(bottom.get(i).get(2), "Shorts") || Objects.equals(bottom.get(i).get(2), "Short skirt") || Objects.equals(bottom.get(i).get(2), "Leggings") || Objects.equals(bottom.get(i).get(2), "Capri & Cropped Pants")) {

                            if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }
                    }

                }

                /*Outer*/
                if (temperature1 <= 20) {
                    for (int i = 0; i < outer.size(); i++) {

                        int number = 0;
                        if (Objects.equals(outer.get(i).get(2), "Jacket") || Objects.equals(outer.get(i).get(2), "Sweater") || Objects.equals(outer.get(i).get(2), "Sweatshirts") || Objects.equals(outer.get(i).get(2), "Hoodies")) {
                            if (Objects.equals(outer.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            } else if (Objects.equals(outer.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            } else if (Objects.equals(outer.get(i).get(4), "Nylon/Polyester") || Objects.equals(outer.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            }

                        }
                    }

                }

                break;

            case "Smart Casual":
                /*TopWear*/
                if (temperature1 <= 15) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Shirt")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 15 && temperature1 <= 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Shirt")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }

                } else if (temperature1 > 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Shirt")) {
                            if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }
                    }


                }

                /*Bottom*/
                if (temperature1 <= 25) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Jeans") || Objects.equals(bottom.get(i).get(2), "Pants")) {
                            if (Objects.equals(bottom.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }
                    }

                } else if (temperature1 > 25) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Jeans") || Objects.equals(bottom.get(i).get(2), "Pants")) {

                            if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }
                    }

                }

                /*Outer*/
                if (temperature1 <= 20) {
                    for (int i = 0; i < outer.size(); i++) {

                        int number = 0;
                        if (Objects.equals(outer.get(i).get(2), "Jacket") || Objects.equals(outer.get(i).get(2), "Blazer")) {
                            if (Objects.equals(outer.get(i).get(4), "Wool")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            } else if (Objects.equals(outer.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            } else if (Objects.equals(outer.get(i).get(4), "Nylon/Polyester") || Objects.equals(outer.get(i).get(4), "Silk")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            }

                        }
                    }

                }

                break;

            case "Wedding":
                /*TopWear*/
                if (temperature1 <= 15) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Gown")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 15 && temperature1 <= 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Gown")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Gown")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }
                    }

                }



                /*Outer*/
                for (int i = 0; i < outer.size(); i++) {
                    int number = 0;
                    if (Objects.equals(outer.get(i).get(2), "Shawl")) {
                        number = number + 10;
                        String s = String.valueOf(number);
                        outer.get(i).set(6, s);
                        outerrightwear.add(outer.get(i));
                    }
                }


                break;

            case "cocktail party":

                /*TopWear*/
                if (temperature1 <= 15) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Short Sleeveless Dress") || Objects.equals(top.get(i).get(2), "Sleeveless Top")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 15 && temperature1 <= 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Short Sleeveless Dress") || Objects.equals(top.get(i).get(2), "Sleeveless Top")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Short Sleeveless Dress") || Objects.equals(top.get(i).get(2), "Sleeveless Top")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }
                    }

                }

                /*Bottom*/
                if (temperature1 < 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Pants") || Objects.equals(bottom.get(i).get(2), "Short skirt")) {
                            if (Objects.equals(bottom.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                } else if (temperature1 >= 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Pants") || Objects.equals(bottom.get(i).get(2), "Short skirt")) {

                            if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                }

                /*Outer*/
                for (int i = 0; i < outer.size(); i++) {
                    int number = 0;
                    if (Objects.equals(outer.get(i).get(2), "Jacket")) {
                        number = number + 10;
                        String s = String.valueOf(number);
                        outer.get(i).set(6, s);
                        outerrightwear.add(outer.get(i));
                    }
                }


                break;


            case "job interview":
                /*TopWear*/
                if (temperature1 <= 15) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }
                    }

                } else if (temperature1 > 15 && temperature1 <= 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }
                    }

                }

                /*Bottom*/
                if (temperature1 < 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Pants") || Objects.equals(bottom.get(i).get(2), "Pencil Skirt")) {
                            if (Objects.equals(bottom.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                } else if (temperature1 >= 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Pants") || Objects.equals(bottom.get(i).get(2), "Pencil Skirt")) {

                            if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                }


                /*Outer*/
                for (int i = 0; i < outer.size(); i++) {
                    int number = 0;
                    if (Objects.equals(outer.get(i).get(2), "Blazer")) {
                        number = number + 10;
                        String s = String.valueOf(number);
                        outer.get(i).set(6, s);
                        outerrightwear.add(outer.get(i));
                    }
                }
                break;

            case "business dinner":
                /*TopWear*/
                if (temperature1 <= 15) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Long Sleeved Dress")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }
                    }

                } else if (temperature1 > 15 && temperature1 <= 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Long Sleeved Dress")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Long Sleeved Dress")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }
                    }

                }

                /*Bottom*/
                if (temperature1 < 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Pants")) {
                            if (Objects.equals(bottom.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                } else if (temperature1 >= 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Pants") || Objects.equals(bottom.get(i).get(2), "Skirt")) {

                            if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                }
                break;


            case "dinner party":
                /*TopWear*/
                if (temperature1 <= 15) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 15 && temperature1 <= 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Short Dress")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "Long Sleeves Shirt") || Objects.equals(top.get(i).get(2), "Short Dress")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }
                    }

                }



                /*Bottom*/
                if (temperature1 < 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Pants") || Objects.equals(top.get(i).get(2), "Jeans") || Objects.equals(top.get(i).get(2), "Capri & Cropped Pants")) {
                            if (Objects.equals(bottom.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Pants") || Objects.equals(top.get(i).get(2), "Jeans") || Objects.equals(top.get(i).get(2), "Capri & Cropped Pants") || Objects.equals(top.get(i).get(2), "Skirt")) {

                            if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                }

                /*Outer*/
                if (temperature1 <= 20) {
                    for (int i = 0; i < outer.size(); i++) {
                        int number = 0;
                        if (Objects.equals(outer.get(i).get(2), "Coat") || Objects.equals(outer.get(i).get(2), "Jacket")) {
                            number = number + 10;
                            String s = String.valueOf(number);
                            outer.get(i).set(6, s);
                            outerrightwear.add(outer.get(i));
                        }
                    }
                }


                break;

            case "beach party":
                /*TopWear*/
                if (temperature1 <= 15) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "T-Shirt") || Objects.equals(top.get(i).get(2), "Shirt") || Objects.equals(top.get(i).get(2), "Top")) {
                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 15 && temperature1 <= 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "T-Shirt") || Objects.equals(top.get(i).get(2), "Shirt") || Objects.equals(top.get(i).get(2), "Top")) {

                            if (Objects.equals(top.get(i).get(4), "Wool")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }

                } else if (temperature1 > 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "T-Shirt") || Objects.equals(top.get(i).get(2), "Shirt") || Objects.equals(top.get(i).get(2), "Top") || Objects.equals(top.get(i).get(2), "Tank Top")) {

                            if (Objects.equals(top.get(i).get(4), "Nylon/Polyester") || Objects.equals(top.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }

                }

                /*Bottom*/
                if (temperature1 < 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Shorts") || Objects.equals(bottom.get(i).get(2), "Skirt")) {
                            if (Objects.equals(bottom.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                } else if (temperature1 >= 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Shorts") || Objects.equals(bottom.get(i).get(2), "Skirt")) {
                            if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester") || Objects.equals(bottom.get(i).get(4), "Silk")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }

                }

                /*Outer*/
                if (temperature1 <= 20) {
                    for (int i = 0; i < outer.size(); i++) {

                        int number = 0;
                        if (Objects.equals(outer.get(i).get(2), "Jacket")) {
                            if (Objects.equals(outer.get(i).get(4), "Wool")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            } else if (Objects.equals(outer.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            } else if (Objects.equals(outer.get(i).get(4), "Nylon/Polyester") || Objects.equals(outer.get(i).get(4), "Silk")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            }

                        }
                    }

                }


                break;

            case "sports":
                /*TopWear*/
                if (temperature1 <= 15) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "T-Shirt")) {
                            if (Objects.equals(top.get(i).get(4), "Nylon/Polyester")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }
                    }
                } else if (temperature1 > 15 && temperature1 <= 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "T-Shirt")) {
                            if (Objects.equals(top.get(i).get(4), "Nylon/Polyester")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }

                    }

                } else if (temperature1 > 25) {
                    for (int i = 0; i < top.size(); i++) {

                        int number = 0;
                        if (Objects.equals(top.get(i).get(2), "T-Shirt")) {
                            if (Objects.equals(top.get(i).get(4), "Nylon/Polyester")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            } else if (Objects.equals(top.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                top.get(i).set(6, s);
                                toprightwear.add(top.get(i));
                            }
                        }
                    }


                }

                /*Bottom*/
                if (temperature1 <= 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Track Pants") || Objects.equals(bottom.get(i).get(2), "Leggings")) {
                            if (Objects.equals(bottom.get(i).get(4), "Wool")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                } else if (temperature1 > 20) {
                    for (int i = 0; i < bottom.size(); i++) {

                        int number = 0;
                        if (Objects.equals(bottom.get(i).get(2), "Track Pants") || Objects.equals(bottom.get(i).get(2), "Shorts") || Objects.equals(bottom.get(i).get(2), "Leggings")) {
                            if (Objects.equals(bottom.get(i).get(4), "Wool")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Cotton")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            } else if (Objects.equals(bottom.get(i).get(4), "Nylon/Polyester")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                bottom.get(i).set(6, s);
                                bottomrightwear.add(bottom.get(i));
                            }
                        }

                    }
                }

                /*Outer*/
                if (temperature1 <= 20) {
                    for (int i = 0; i < outer.size(); i++) {

                        int number = 0;
                        if (Objects.equals(outer.get(i).get(2), "Jacket") || Objects.equals(outer.get(i).get(2), "Track Suit")) {
                            if (Objects.equals(outer.get(i).get(4), "Wool")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            } else if (Objects.equals(outer.get(i).get(4), "Cotton")) {
                                number = number + 5;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            } else if (Objects.equals(outer.get(i).get(4), "Nylon/Polyester")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            }

                        }

                    }
                } else if (temperature1 > 20) {
                    for (int i = 0; i < outer.size(); i++) {

                        int number = 0;
                        if (Objects.equals(outer.get(i).get(2), "Jacket") || Objects.equals(outer.get(i).get(2), "Track Suit")) {
                            if (Objects.equals(outer.get(i).get(4), "Wool")) {
                                number = number + 2;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            } else if (Objects.equals(outer.get(i).get(4), "Cotton")) {
                                number = number + 7;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            } else if (Objects.equals(outer.get(i).get(4), "Nylon/Polyester")) {
                                number = number + 10;
                                String s = String.valueOf(number);
                                outer.get(i).set(6, s);
                                outerrightwear.add(outer.get(i));
                            }

                        }
                    }


                }

                break;

            default:
        }
        Log.v("AAA", "TopWear");
        ArrayList<ImageModel> imageModels = new ArrayList<>();
        for (int i = 0; i < toprightwear.size(); i++) {
            ImageModel im = new ImageModel();
            im.setId(toprightwear.get(i).get(1));
            Uri imageUri = Uri.parse(toprightwear.get(i).get(5));
            Bitmap image = null;
            try {
                image = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageUri);
            } catch (Exception e) {
                e.printStackTrace();
            }
            im.setPic(image);
            im.setText(toprightwear.get(i).get(2));
            imageModels.add(im);
            Log.v("AAA", toprightwear.get(i).get(0) + "," + toprightwear.get(i).get(1) + "," + toprightwear.get(i).get(2) + ","
                    + toprightwear.get(i).get(3) + "," + toprightwear.get(i).get(4) + "," + toprightwear.get(i).get(6) + ",");

        }
        Log.v("AAA", "BottomWear");
        for (int i = 0; i < bottomrightwear.size(); i++) {
            ImageModel im = new ImageModel();
            im.setId(bottomrightwear.get(i).get(1));
            Uri imageUri = Uri.parse(bottomrightwear.get(i).get(5));
            Bitmap image = null;
            try {
                image = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageUri);
            } catch (Exception e) {
                e.printStackTrace();
            }
            im.setPic(image);
            im.setText(bottomrightwear.get(i).get(2));
            imageModels.add(im);
            Log.v("AAA", bottomrightwear.get(i).get(0) + "," + bottomrightwear.get(i).get(1) + "," + bottomrightwear.get(i).get(2) + ","
                    + bottomrightwear.get(i).get(3) + "," + bottomrightwear.get(i).get(4) + "," + bottomrightwear.get(i).get(6) + ",");
        }
        Log.v("AAA", "OuterWear");
        for (int i = 0; i < outerrightwear.size(); i++) {
            ImageModel im = new ImageModel();
            im.setId(outerrightwear.get(i).get(1));
            Uri imageUri = Uri.parse(outerrightwear.get(i).get(5));
            Bitmap image = null;
            try {
                image = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageUri);
            } catch (Exception e) {
                e.printStackTrace();
            }
            im.setPic(image);
            im.setText(outerrightwear.get(i).get(2));
            imageModels.add(im);
            Log.v("AAA", outerrightwear.get(i).get(0) + "," + outerrightwear.get(i).get(1) + "," + outerrightwear.get(i).get(2) + ","
                    + outerrightwear.get(i).get(3) + "," + outerrightwear.get(i).get(4) + "," + outerrightwear.get(i).get(6) + ",");
        }
        return imageModels;
    }

    public ArrayList<ReturnClothLogicModelLists> generateSets(String baseId, String baseOut) {

        String baseoutfitid = baseId;
        String baseOutfit = "";
        if (baseOut == null) {
            ClothesDB db = new ClothesDB(getContext());
            ClothesModel cm = db.getCloth(MainActivity.user.getUsername(), baseId);
            baseOutfit = cm.getCategory();
        } else {
            baseOutfit = baseOut;
        }
//        Log.v("BBB1",);
        ArrayList<String> str = new ArrayList<String>();
        str.add("No suitable outerwear");

        ArrayList<String> str1 = new ArrayList<String>();
        str1.add("No bottomwear for current selected topwear");

        ArrayList<ArrayList<ArrayList<String>>> outfits = new ArrayList<>();
        ArrayList<String> base = new ArrayList<String>();
        String baseType = "";
        switch (baseOutfit) {
            case "topwear":
                for (int i = 0; i < toprightwear.size(); i++) {
                    if (Objects.equals(toprightwear.get(i).get(1), baseoutfitid)) {
                        base = toprightwear.get(i);
                        baseType = toprightwear.get(i).get(2);
                    }
                }
                if (outerrightwear.isEmpty()) {
                    if (Objects.equals(baseType, "Gown") || Objects.equals(baseType, "Long Sleeved Dress") || Objects.equals(baseType, "Short Sleeveless Dress") || Objects.equals(baseType, "Short  Dress") || Objects.equals(baseType, "Long Dress")) {
                        for (int j = 0; j < toprightwear.size(); j++) {
                            ArrayList<ArrayList<String>> outfitPairs = new ArrayList<ArrayList<String>>();
                            outfitPairs.add(base);
                            outfitPairs.add(str1);
                            outfitPairs.add(str);
                            outfits.add(outfitPairs);
                        }
                    } else {
                        for (int j = 0; j < bottomrightwear.size(); j++) {
                            ArrayList<ArrayList<String>> outfitPairs = new ArrayList<ArrayList<String>>();
                            outfitPairs.add(base);
                            outfitPairs.add(bottomrightwear.get(j));
                            outfitPairs.add(str);
                            outfits.add(outfitPairs);
                        }
                    }
                } else {
                    if (Objects.equals(baseType, "Gown") || Objects.equals(baseType, "Long Sleeved Dress") || Objects.equals(baseType, "Short Sleeveless Dress") || Objects.equals(baseType, "Short  Dress") || Objects.equals(baseType, "Long Dress")) {
                        for (int j = 0; j < toprightwear.size(); j++) {
                            for (int k = 0; k < outerrightwear.size(); k++) {
                                ArrayList<ArrayList<String>> outfitPairs = new ArrayList<ArrayList<String>>();
                                outfitPairs.add(base);
                                outfitPairs.add(str1);
                                outfitPairs.add(outerrightwear.get(k));
                                outfits.add(outfitPairs);
                            }
                        }
                    } else {
                        for (int j = 0; j < bottomrightwear.size(); j++) {
                            for (int k = 0; k < outerrightwear.size(); k++) {
                                ArrayList<ArrayList<String>> outfitPairs = new ArrayList<ArrayList<String>>();
                                outfitPairs.add(base);
                                outfitPairs.add(bottomrightwear.get(j));
                                outfitPairs.add(outerrightwear.get(k));
                                outfits.add(outfitPairs);
                            }
                        }
                    }
                }
                break;
            case "bottomwear":
                for (int i = 0; i < bottomrightwear.size(); i++) {
                    if (Objects.equals(bottomrightwear.get(i).get(1), baseoutfitid)) {
                        base = bottomrightwear.get(i);
                    }
                }
                if (outerrightwear.isEmpty()) {
                    for (int j = 0; j < toprightwear.size(); j++) {
                        if (Objects.equals(toprightwear.get(j).get(2), "Gown") || Objects.equals(toprightwear.get(j).get(2), "Long Sleeved Dress") || Objects.equals(toprightwear.get(j).get(2), "Short Sleeveless Dress") || Objects.equals(toprightwear.get(j).get(2), "Short  Dress") || Objects.equals(toprightwear.get(j).get(2), "Long Dress")) {
                        } else {
                            ArrayList<ArrayList<String>> outfitPairs = new ArrayList<ArrayList<String>>();
                            outfitPairs.add(toprightwear.get(j));
                            outfitPairs.add(base);
                            outfitPairs.add(str);
                            outfits.add(outfitPairs);
                        }
                    }
                } else {
                    for (int j = 0; j < toprightwear.size(); j++) {
                        for (int k = 0; k < outerrightwear.size(); k++) {
                            if (Objects.equals(toprightwear.get(j).get(2), "Gown") || Objects.equals(toprightwear.get(j).get(2), "Long Sleeved Dress") || Objects.equals(toprightwear.get(j).get(2), "Short Sleeveless Dress") || Objects.equals(toprightwear.get(j).get(2), "Short  Dress") || Objects.equals(toprightwear.get(j).get(2), "Long Dress")) {
                            } else {
                                ArrayList<ArrayList<String>> outfitPairs = new ArrayList<ArrayList<String>>();
                                outfitPairs.add(toprightwear.get(j));
                                outfitPairs.add(base);
                                outfitPairs.add(outerrightwear.get(k));
                                outfits.add(outfitPairs);
                            }
                        }
                    }
                }
                break;
            case "feelinglucky":
                if (outerrightwear.isEmpty()) {
                    for (int i = 0; i < toprightwear.size(); i++) {
                        for (int j = 0; j < bottomrightwear.size(); j++) {
                            if (Objects.equals(toprightwear.get(i).get(2), "Gown") || Objects.equals(toprightwear.get(i).get(2), "Long Sleeved Dress") || Objects.equals(toprightwear.get(i).get(2), "Short Sleeveless Dress") || Objects.equals(toprightwear.get(i).get(2), "Short  Dress") || Objects.equals(toprightwear.get(i).get(2), "Long Dress")) {
                                ArrayList<ArrayList<String>> outfitPairs = new ArrayList<ArrayList<String>>();
                                outfitPairs.add(toprightwear.get(i));
                                outfitPairs.add(str1);
                                outfitPairs.add(str);
                                outfits.add(outfitPairs);
                            } else {
                                ArrayList<ArrayList<String>> outfitPairs = new ArrayList<ArrayList<String>>();
                                outfitPairs.add(toprightwear.get(i));
                                outfitPairs.add(bottomrightwear.get(j));
                                outfitPairs.add(str);
                                outfits.add(outfitPairs);
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < toprightwear.size(); i++) {
                        for (int j = 0; j < bottomrightwear.size(); j++) {
                            for (int k = 0; k < outerrightwear.size(); k++) {
                                if (Objects.equals(toprightwear.get(i).get(2), "Gown") || Objects.equals(toprightwear.get(i).get(2), "Long Sleeved Dress") || Objects.equals(toprightwear.get(i).get(2), "Short Sleeveless Dress") || Objects.equals(toprightwear.get(i).get(2), "Short  Dress") || Objects.equals(toprightwear.get(i).get(2), "Long Dress")) {
                                    ArrayList<ArrayList<String>> outfitPairs = new ArrayList<ArrayList<String>>();
                                    outfitPairs.add(toprightwear.get(i));
                                    outfitPairs.add(str1);
                                    outfitPairs.add(outerrightwear.get(k));
                                    outfits.add(outfitPairs);
                                } else {
                                    ArrayList<ArrayList<String>> outfitPairs = new ArrayList<ArrayList<String>>();
                                    outfitPairs.add(toprightwear.get(i));
                                    outfitPairs.add(bottomrightwear.get(j));
                                    outfitPairs.add(outerrightwear.get(k));
                                    outfits.add(outfitPairs);
                                }
                            }
                        }
                    }
                }
                break;
            default:
                // code block
        }
        ArrayList<ArrayList<ArrayList<String>>> pair = outfits;
        ArrayList<ReturnClothLogicModelLists> retList = new ArrayList<>();
        Log.v("BBBpair", "" + pair.size());
        ClothesDB db = new ClothesDB(getContext());
        for (int i = 0; i < pair.size(); i++) {
            int sum = 0;
            int z = 0;
            ColourMatch colorMatch = new ColourMatch();
            PatternMatch patternMatch = new PatternMatch();
            ArrayList<String> colorStringPair = new ArrayList<>();
            ArrayList<String> patternStringPair = new ArrayList<>();
            for (int j = 0; j < pair.get(i).size(); j++) {
//                z=j;
                if (pair.get(i).get(j).size() > 1) {
                    sum += Integer.parseInt(pair.get(i).get(j).get(6));
                    ClothesModel cm = db.getCloth(pair.get(i).get(j).get(0), pair.get(i).get(j).get(1));
                    LastWornRank l = new LastWornRank();
                    long r = l.getRank(cm.getLastworn(), cm.getCategory());
                    Log.v("BBBLastWorn", "" + r);
                    Log.v("BBBLastWorn", "#" + pair.get(i).get(j).get(3).substring(3));
                    colorStringPair.add("#" + pair.get(i).get(j).get(3).substring(3));
                    Log.v("CCCsum1", "" + cm.getPattern());
                    Log.v("DDDpatternVallue", "" + cm.getPattern());
                    patternStringPair.add(cm.getPattern());
                    sum += r;
                }
            }
            String[] colorString = new String[colorStringPair.size()];
            colorString = colorStringPair.toArray(colorString);

            String[] patternString = new String[patternStringPair.size()];
            patternString = patternStringPair.toArray(patternString);

            int colorRank = colorMatch.getRank(colorString);
            int patternRank = patternMatch.getRank(patternString,setOccasion());

            Log.v("CCCsum1", "" + sum);
            sum += colorRank;
            sum += patternRank;
            Log.v("CCCcolor", "" + colorRank);
            Log.v("CCCpattern", "" + patternRank);
            Log.v("CCCsum2", "" + sum);

            ReturnClothLogicModelLists r = new ReturnClothLogicModelLists(pair.get(i), sum);

            Boolean added = false;
            for (int a = 0; a < retList.size(); a++) {
                Log.v("UUUrank", "" + r.getRankSum());
                if (retList.get(a).getRankSum() <= r.getRankSum()) {
                    retList.add(a, r);
                    added = true;
                    Log.v("RRR", "" + added);
                    break;
                }
            }
            if (!added) {
                retList.add(r);
            }
        }
        return retList;
    }

}

