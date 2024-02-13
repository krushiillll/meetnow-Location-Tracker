package com.meetnow.location.tracker;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.OnDismiss;


import java.util.ArrayList;

public class PersonalAdapterBankList extends RecyclerView.Adapter<PersonalAdapterBankList.ViewHolder> {

    ArrayList<ModelBanks> modelBanks;
    Personal_BankInfo_Activity info_activity;
    int counter = 0;

    public PersonalAdapterBankList(ArrayList<ModelBanks> modelBanks, Personal_BankInfo_Activity info_activity) {
        this.modelBanks = modelBanks;
        this.info_activity = info_activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(info_activity).inflate(R.layout.personal_bank_item_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelBanks bank = modelBanks.get(position);
        holder.TVBank.setText(bank.strBankName);
        holder.IVBank.setImageResource(bank.icon);

        holder.bankRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter++;
                if (counter > Personal_Splash_Activity.frequency) {
                    Intent intent = new Intent(info_activity, Personal_BankDetailInfo_Activity.class);
                    intent.putExtra("name", bank.getStrBankName());
                    intent.putExtra("balance", bank.getStrBalance());
                    intent.putExtra("customercare", bank.getStrCustomerCare());
                    intent.putExtra("icon", bank.getIcon());
                    intent.putExtra("statement", bank.getStrMiniStatement());
                    info_activity.startActivity(intent);
                    info_activity.startActivity(intent);
                } else {
                    new InterAdClass(new OnDismiss() {
                        @Override
                        public void onDismiss() {
                            Intent intent = new Intent(info_activity, Personal_BankDetailInfo_Activity.class);
                            intent.putExtra("name", bank.getStrBankName());
                            intent.putExtra("balance", bank.getStrBalance());
                            intent.putExtra("customercare", bank.getStrCustomerCare());
                            intent.putExtra("icon", bank.getIcon());
                            intent.putExtra("statement", bank.getStrMiniStatement());
                            info_activity.startActivity(intent);
                        }
                    }).showIntAd(info_activity);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelBanks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView TVBank;
        RelativeLayout bankRl;
        ImageView IVBank;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TVBank = (TextView) itemView.findViewById(R.id.TVBank);
            bankRl = (RelativeLayout) itemView.findViewById(R.id.bankRl);
            IVBank = (ImageView) itemView.findViewById(R.id.IVBank);
        }
    }
}
