package model.Management;

public class TitleBook {
    private int titleId;
    private String titleName;

    public TitleBook() {
    }

    public TitleBook(int titleId, String titleName) {
        this.titleId = titleId;
        this.titleName = titleName;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
