package com.meetnow.location.tracker;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.meetnow.location.tracker.Ads.AdsClass;

import java.util.ArrayList;

public class Personal_BankInfo_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelBanks> modelBanks = new ArrayList<ModelBanks>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_bank_info_activity);

        recyclerView = (RecyclerView) findViewById(R.id.listview);

        AdsClass.loadSmallNativeAd(this);

        modelBanks.add(new ModelBanks("Axis Bank", "18004195959", "18002095577", R.drawable.bank_axis, "18004196969"));
        modelBanks.add(new ModelBanks("Allahabad Bank", "09224160150", "1800226061", R.drawable.bank_allhabad, "09224150150"));
        modelBanks.add(new ModelBanks("Bank Of Baroda", "09223011311", "18001024455", R.drawable.bank_bank_of_baroda, "8468001111"));
        modelBanks.add(new ModelBanks("Bandhan Bank", "9223008666", "1800 258 8181", R.drawable.bank_bandhanbank, "9223008777"));
        modelBanks.add(new ModelBanks("Bharatiya Mahila Bank", "09212438888", "01147472100", R.drawable.bank_bharatiya_mahila, "9212438888"));
        modelBanks.add(new ModelBanks("Central Bank Of India", "09222250000", "18002001911", R.drawable.bank_central_bank_of_india, "9555144441"));
        modelBanks.add(new ModelBanks("Canara Bank", "09015483483", "18004250018", R.drawable.bank_canara, "09015734734"));
        modelBanks.add(new ModelBanks("Dena Bank", "09289356677", "18002336427", R.drawable.bank_dena_bank, "09278656677"));
        modelBanks.add(new ModelBanks("Dhanlakshmi Bank", "08067747700", "18004251747", R.drawable.bank_dhanlaxmi_bank, "08067747711"));
        modelBanks.add(new ModelBanks("DCB Bank", "7506660011", "18002095363", R.drawable.bank_dcbbank, "07506660022"));
        modelBanks.add(new ModelBanks("Federal Bank", "8431900900", "18004251199", R.drawable.bank_federal, "8431600600"));
        modelBanks.add(new ModelBanks("HDFC Bank", "18002703333", "18004254332", R.drawable.bank_hdfc_bank, "18002703355"));
        modelBanks.add(new ModelBanks("IDBI Bank", "18008431122", "18002001947", R.drawable.bank_idbi_bank, "18008431133"));
        modelBanks.add(new ModelBanks("ICICI Bank", "9594612612", "18001038181", R.drawable.bank_icici, "9594613613"));
        modelBanks.add(new ModelBanks("IndusInd Bank", "18002741000", "1860 500 5004", R.drawable.bank_indusindbank, "9212299955"));
        modelBanks.add(new ModelBanks("ING Vysya Bank", "09266292666", "18004209900", R.drawable.bank_ing_bank, "09266292665"));
        modelBanks.add(new ModelBanks("Karur Vysya Bank", "09266292666", "18602001916", R.drawable.bank_karur_vysya_bank, "09266292665"));
        modelBanks.add(new ModelBanks("Karnataka Bank", "18004251445", "18004251444", R.drawable.bank_karnataka_bank, "18004251446"));
        modelBanks.add(new ModelBanks("Oriental Bank of Commerce", "08067205757", "1800 180 1235", R.drawable.bank_orientalbankofcommerce, "08067205767"));
        modelBanks.add(new ModelBanks("Punjab National Bank", "18001802223", "18001802222", R.drawable.bank_punjab_national_bank, "01202490000"));
        modelBanks.add(new ModelBanks("RBL Bank", "1800 419 0610", "1800 123 8040", R.drawable.bank_rblbank, "1800 419 0610"));
        modelBanks.add(new ModelBanks("State Bank of India", "09223766666", "18004253800", R.drawable.bank_state_bank_of_india, "09223866666"));
        modelBanks.add(new ModelBanks("Saraswat Bank", "9223040000", "1800229999", R.drawable.bank_saraswat_bank, "9223501111"));
        modelBanks.add(new ModelBanks("State bank of mysore", "1800-180-2010", "18004252244", R.drawable.bank_statebankofmysore, "09223866666"));
        modelBanks.add(new ModelBanks("State Bank of Patiala", "1800-180-2010", "18004252244", R.drawable.bank_statebankofpatiala, "09223866666"));
        modelBanks.add(new ModelBanks("South Indian Bank", "09223008488", "18008431800", R.drawable.bank_south_indian_bank, "9223008488"));
        modelBanks.add(new ModelBanks("Tamilnad Mercantile Bank", "09664552255", "9842461461", R.drawable.bank_tamilnad_mercantile_bank, "08067006979"));
        modelBanks.add(new ModelBanks("Union Bank Of India", "09223009292", "18001030123", R.drawable.bank_union_bank_of_india, "UMNS 09223008486"));
        modelBanks.add(new ModelBanks("UCO Bank", "09278792787", "18001030123", R.drawable.bank_uco_bank, "09213125125"));
        modelBanks.add(new ModelBanks("Varachha bank", "0261-4008080", "9586644644", R.drawable.bank_varachhabank, "0261-4008080"));
        modelBanks.add(new ModelBanks("Vijaya Bank", "1800 103 5525", "18004255885", R.drawable.bank_vijaya_bank, "1800 103 5535"));
        modelBanks.add(new ModelBanks("Yes Bank", "09223920000", "18002000", R.drawable.bank_yes, "09223921111"));
        modelBanks.add(new ModelBanks("Royal bank of scotland", "08435573401", "1800112224", R.drawable.bank_royalbankofscotland, "Not Available"));
        modelBanks.add(new ModelBanks("City Bank", "18004252484", "1800226747", R.drawable.bank_citi_bank, "Just SMS to 52484 (Format:-BAL<space>Last 4 digits of your debit card number)"));
        modelBanks.add(new ModelBanks("Kotak Mahindra Bank", "18002740110", "18602662666", R.drawable.bank_kotak_bank, "Just SMS to 9971056767(Format:-TXN(space)Last 4 digits of Account Number) "));
        modelBanks.add(new ModelBanks("Bank Of India", "09015135135", "1800220229", R.drawable.bank_bank_of_india, "Not Available "));
        modelBanks.add(new ModelBanks("Corporation Bank", "09289792897", "18004253555", R.drawable.bank_corporation_bank, "Not Available"));
        modelBanks.add(new ModelBanks("American Express", "1800446630", "1800446630", R.drawable.bank_american_express, "Not Available"));
        modelBanks.add(new ModelBanks("HSBS Bank", "18001034722", "18001034722", R.drawable.bank_hsbc_bank, "Not Available"));
        modelBanks.add(new ModelBanks("Indian Overseas Bank", "18004254445", "18004254445", R.drawable.bank_indian_overseas_bank, "Not Available"));
        modelBanks.add(new ModelBanks("ABN AMRO", "1800112224", "1800112224", R.drawable.bank_abn_amro, "Not Available"));
        modelBanks.add(new ModelBanks("Andhra Bank", "09223011300", "18004251515", R.drawable.bank_andhra, "Not Available"));
        modelBanks.add(new ModelBanks("ANZ Bank", "18002000269", "18002000269", R.drawable.bank_anz, "Not vailable"));
        modelBanks.add(new ModelBanks("Bank Of Maharashtra", "1800-102-2636", "18002334526", R.drawable.bank_of_maharashtra, "Not Available"));
        modelBanks.add(new ModelBanks("Barclays Bank", "18002336565", "0442476842100", R.drawable.bank_barclays, "Not Available"));
        modelBanks.add(new ModelBanks("Indian Bank", "09289592895", "180042500000", R.drawable.bank_indian_bank, "Not Available"));
        modelBanks.add(new ModelBanks("Punjab and Sindh Bank", "1800221908", "1800221908", R.drawable.bank_punjab_and_sind_bank, "Just SMS(NPTXN A/c No. SMS-Banking-Password)"));
        modelBanks.add(new ModelBanks("Cashnet Bank", "1800225087", "1800225087", R.drawable.bank_cashnet_bank, "Not Available"));
        modelBanks.add(new ModelBanks("Centurion Bank Of Punjab", "1800443555", "18004253555", R.drawable.bank_of_punjab, "Not Available"));
        modelBanks.add(new ModelBanks("Standard Chartered Bank", "18003451212", "18003455000", R.drawable.bank_standard_chartered_bank, "Not Available"));
        modelBanks.add(new ModelBanks("State Bank of Bikaner", "09223866666", "18001806005", R.drawable.bank_of_bikaner_and_jaipur, "Not Available"));
        modelBanks.add(new ModelBanks("Deutsche Bank", "18001236601", "18001236601", R.drawable.bank_deutsche_bank, "Not Available"));
        modelBanks.add(new ModelBanks("State Bank Of Travancore", "09223866666", "18004255566", R.drawable.bank_state_bank_of_travancore, "Not Available"));
        modelBanks.add(new ModelBanks("Syndicate Bank", "09664552255", "08026639966", R.drawable.bank_syndicate_bank, "Not Available"));
        modelBanks.add(new ModelBanks("United Bank Of India", "09015431345", "18003450345", R.drawable.bank_of_india, "Not Available"));

        recyclerView.setAdapter(new PersonalAdapterBankList(modelBanks, Personal_BankInfo_Activity.this));
        recyclerView.setLayoutManager(new LinearLayoutManager(Personal_BankInfo_Activity.this));
    }

    public void back(View view) {

        onBackPressed();
    }
}