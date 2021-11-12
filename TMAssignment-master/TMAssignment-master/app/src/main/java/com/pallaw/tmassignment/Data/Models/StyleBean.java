package com.pallaw.tmassignment.Data.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StyleBean {
    @Expose @SerializedName("original") public String original;
    @Expose @SerializedName("thumb") public String thumb;
    @Expose @SerializedName("large") public String large;
    @Expose @SerializedName("medium") public String medium;
}
