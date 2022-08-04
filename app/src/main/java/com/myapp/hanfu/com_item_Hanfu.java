package com.myapp.hanfu;

public class com_item_Hanfu {
    private String name;
    private String dynasty;
    private int imageID;
    private String infor;

    //不带具体信息的构造
    public com_item_Hanfu(String dynasty, String name, int imageID){
        this.dynasty=dynasty;
        this.name=name;
        this.imageID=imageID;
    }
    public com_item_Hanfu(String dynasty, String name, int imageID, String infor){
        this.dynasty=dynasty;
        this.name=name;
        this.imageID=imageID;
        this.infor=infor;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }
}
