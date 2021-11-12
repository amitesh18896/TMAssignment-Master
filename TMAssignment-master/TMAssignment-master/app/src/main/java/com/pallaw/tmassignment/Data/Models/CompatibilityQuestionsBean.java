package com.pallaw.tmassignment.Data.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompatibilityQuestionsBean {
    @Expose @SerializedName("style") public StyleBean style;
    @Expose @SerializedName("cross") public String cross;
    @Expose @SerializedName("tick") public String tick;
    @Expose @SerializedName("question") public String question;
    @Expose @SerializedName("id") public int id;
}
