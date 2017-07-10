package edu.ritwijsn.cs478.project2;

/**
 * Created by Ritwij on 02-Oct-16.
 */

public class DealerInformation {
    private String name = "";
    private String address = "";
    private String phone = "";

    public DealerInformation(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
