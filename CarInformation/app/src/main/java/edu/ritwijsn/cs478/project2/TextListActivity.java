package edu.ritwijsn.cs478.project2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Ritwij on 02-Oct-16.
 */

public class TextListActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_view);

        ArrayList<ArrayList<DealerInformation>> dealers = getDealerInformations();
        int position = getIntent().getExtras().getInt("position");
        final ListView listView = (ListView) findViewById(R.id.srListView);
        listView.setAdapter(new TextListAdapter(this, dealers.get(position)));
    }

    public ArrayList<ArrayList<DealerInformation>> getDealerInformations(){
        ArrayList<ArrayList<DealerInformation>> results = new ArrayList<ArrayList<DealerInformation>>();

        ArrayList<DealerInformation> dealers0 = new ArrayList<DealerInformation>();
        DealerInformation dealerInformation = new DealerInformation("Rogers Hyundai", "2700 S Michigan Ave, Chicago, IL 60616", "(312) 428-4243");
        dealers0.add(0, dealerInformation);
        dealerInformation = new DealerInformation("Greater Chicago Motors", "1850 N Elston Ave, Chicago, IL 60642", "(312) 280-9262");
        dealers0.add(1, dealerInformation);
        dealerInformation = new DealerInformation("McGrath City Hyundai", "6720 W Grand Ave, Chicago, IL 60707", "(773) 889-9090");
        dealers0.add(2, dealerInformation);
        results.add(0, dealers0);

        ArrayList<DealerInformation> dealers1 = new ArrayList<DealerInformation>();
        dealerInformation = new DealerInformation("Fletcher Jones Honda", "1100 N Clark St, Chicago, IL 60610", "(312) 267-0803");
        dealers1.add(0, dealerInformation);
        dealerInformation = new DealerInformation("Greater Chicago Motors", "1850 N Elston Ave, Chicago, IL 60642", "(312) 280-9262");
        dealers1.add(1, dealerInformation);
        dealerInformation = new DealerInformation("McGrath City Honda", "6720 W Grand Ave, Chicago, IL 60707", "(773) 889-3030");
        dealers1.add(2, dealerInformation);
        results.add(1, dealers1);

        ArrayList<DealerInformation> dealers2 = new ArrayList<DealerInformation>();
        dealerInformation = new DealerInformation("Alfa Romeo & FIAT of Chicago", "2401 S Michigan Ave, Chicago, IL 60616", "(312) 902-3428");
        dealers2.add(0, dealerInformation);
        dealerInformation = new DealerInformation("South Chicago Chrysler", "7340 S Western Ave, Chicago, IL 60636", "(773) 476-7800");
        dealers2.add(1, dealerInformation);
        dealerInformation = new DealerInformation("Napleton's Northwestern Chrysler", "5950 N Western Ave, Chicago, IL 60659", "(773) 334-3400");
        dealers2.add(2, dealerInformation);
        results.add(2, dealers2);

        ArrayList<DealerInformation> dealers3 = new ArrayList<DealerInformation>();
        dealerInformation = new DealerInformation("Perillo BMW", "1035 N Clark St, Chicago, IL 60610", "(312) 902-3428");
        dealers3.add(0, dealerInformation);
        dealerInformation = new DealerInformation("Elmhurst BMW", "466 W Lake St, Elmhurst, IL 60126", "(630) 833-7945");
        dealers3.add(1, dealerInformation);
        dealerInformation = new DealerInformation("Fields BMW Northfield", "700 Frontage Rd, Northfield, IL 60093", "(847) 441-5300");
        dealers3.add(2, dealerInformation);
        results.add(3, dealers3);

        ArrayList<DealerInformation> dealers4 = new ArrayList<DealerInformation>();
        dealerInformation = new DealerInformation("Mercedes-Benz of Chicago", "1520 W North Ave, Chicago, IL 60642", "(773) 796-7686");
        dealers4.add(0, dealerInformation);
        dealerInformation = new DealerInformation("Mercedes-Benz of Hoffman Estates", "1000 W Golf Rd, Hoffman Estates, IL 60169", "(847) 885-7000");
        dealers4.add(1, dealerInformation);
        dealerInformation = new DealerInformation("Mercedes-Benz of Westmont", "200 E Ogden Ave, Westmont, IL 60559", "(630) 537-0313");
        dealers4.add(2, dealerInformation);
        results.add(4, dealers4);

        ArrayList<DealerInformation> dealers5 = new ArrayList<DealerInformation>();
        dealerInformation = new DealerInformation("South Chicago Dodge", "1520 W North Ave, Chicago, IL 60642", "(773) 796-7686");
        dealers5.add(0, dealerInformation);
        dealerInformation = new DealerInformation("Midway Dodge", "4747 S Pulaski Rd, Chicago, IL 60632", "(773) 376-8060");
        dealers5.add(1, dealerInformation);
        dealerInformation = new DealerInformation("Marino Dodge", "5133 W Irving Park Rd, Chicago, IL 60641", "(877) 693-6059");
        dealers5.add(2, dealerInformation);
        results.add(5, dealers5);

        ArrayList<DealerInformation> dealers6 = new ArrayList<DealerInformation>();
        dealerInformation = new DealerInformation("Windy City Motors", "2662 N Cicero Ave, Chicago, IL 60639", "(773) 717-7000");
        dealers6.add(0, dealerInformation);
        dealerInformation = new DealerInformation("Mid City Nissan", "4444 W Irving Park Rd, Chicago, IL 60641", "(773) 282-6200");
        dealers6.add(1, dealerInformation);
        dealerInformation = new DealerInformation("Star Nissan", "5757 W Touhy Ave, Niles, IL 60714", "(847) 440-3648");
        dealers6.add(2, dealerInformation);
        results.add(6, dealers6);

        ArrayList<DealerInformation> dealers7 = new ArrayList<DealerInformation>();
        dealerInformation = new DealerInformation("Rogers Buick GMC", "2720 S Michigan Ave, Chicago, IL 60616", "(312) 225-4300");
        dealers7.add(0, dealerInformation);
        dealerInformation = new DealerInformation("Castle Buick-GMC", "7400 W Cermak Rd, North Riverside, IL 60546", "(708) 442-7474");
        dealers7.add(1, dealerInformation);
        dealerInformation = new DealerInformation("Haggerty Buick GMC", "300 W Roosevelt Rd, Villa Park, IL 60181", "(630) 279-2000");
        dealers7.add(2, dealerInformation);
        results.add(7, dealers7);

        ArrayList<DealerInformation> dealers8 = new ArrayList<DealerInformation>();
        dealerInformation = new DealerInformation("Marino Jeep", "5133 W Irving Park Rd, Chicago, IL 60641", "(877) 693-6059");
        dealers8.add(0, dealerInformation);
        dealerInformation = new DealerInformation("South Chicago Jeep", "1520 W North Ave, Chicago, IL 60642", "(773) 796-7686");
        dealers8.add(1, dealerInformation);
        dealerInformation = new DealerInformation("Hawk Jeep", "7911 W Roosevelt Rd, Forest Park, IL 60130", "(708) 366-1001");
        dealers8.add(2, dealerInformation);
        results.add(8, dealers8);

        ArrayList<DealerInformation> dealers9 = new ArrayList<DealerInformation>();
        dealerInformation = new DealerInformation("Toyota On Western", "6941 S Western Ave, Chicago, IL 60636", "(773) 884-7200");
        dealers9.add(0, dealerInformation);
        dealerInformation = new DealerInformation("Midtown Toyota", "2700 N Cicero Ave, Chicago, IL 60639", "(888) 855-7107");
        dealers9.add(1, dealerInformation);
        dealerInformation = new DealerInformation("Chicago Northside Toyota", "5625 North Broadway, Chicago, IL 60660", "(773) 728-5000");
        dealers9.add(2, dealerInformation);
        results.add(9, dealers9);

        return results;
    }
}
