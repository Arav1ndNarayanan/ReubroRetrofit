package com.example.reubroretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NoticeList {
/*

    @SerializedName("users")
    private List<Notice> noticeList;

    public List<Notice> getNoticeArrayList() {
        return noticeList;
    }

    public void setNoticeArrayList(ArrayList<Notice> noticeArrayList) {
        this.noticeList = noticeArrayList;
    }
}
*/

    @SerializedName("users")
    @Expose
    private List<Notice> noticeList = null;

    public List<Notice> getUsers() {
        return noticeList;
    }

    public void setUsers(List<Notice> users) {
        this.noticeList = users;
    }

}