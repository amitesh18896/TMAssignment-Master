package com.pallaw.tmassignment.Data.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroupLeaveReasonsBean {
    @Expose @SerializedName("type") public String type;
    @Expose @SerializedName("rank") public int rank;
    @Expose @SerializedName("name") public String name;
    @Expose @SerializedName("id") public int id;
}
