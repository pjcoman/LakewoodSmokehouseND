package comapps.com.lakewoodsmokehousend.menu;

import java.io.Serializable;

public class MenuObject implements Serializable {


    private String item;
    private String group;
    private String price;
    private String description;
    private String quantitylabel;
    private Integer quantity;
    private Integer selection;
    private Integer selection2;
    private Integer selection3;
    private Integer selection4;
    private Integer selection5;
    private Integer selection6;
    private String order;

    public MenuObject()
    {

    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantityLabel() {
        return quantitylabel;
    }

    public void setQuantityLabel(String quantitylabel) {
        this.quantitylabel = quantitylabel;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSelection() {
        return selection;
    }

    public void setSelection(Integer selection) {
        this.selection = selection;
    }





    public Integer getSelection2() {
        return selection2;
    }

    public void setSelection2(Integer selection2) {
        this.selection2 = selection2;
    }






    public Integer getSelection3() {
        return selection3;
    }

    public void setSelection3(Integer selection3) {
        this.selection3 = selection3;
    }





    public Integer getSelection4() {
        return selection4;
    }

    public void setSelection4(Integer selection4) {
        this.selection4 = selection4;
    }






    public Integer getSelection5() {
        return selection5;
    }

    public void setSelection5(Integer selection5) {
        this.selection5 = selection5;
    }




    public Integer getSelection6() {
        return selection6;
    }

    public void setSelection6(Integer selection6) {
        this.selection6 = selection6;
    }



    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }


}
