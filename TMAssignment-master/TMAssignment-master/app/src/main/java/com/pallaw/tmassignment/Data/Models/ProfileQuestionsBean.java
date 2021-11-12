package com.pallaw.tmassignment.Data.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileQuestionsBean {
    @Expose @SerializedName("suggestion") public String suggestion;
    @Expose @SerializedName("question") public String question;
    @Expose @SerializedName("id") public int id;
}
