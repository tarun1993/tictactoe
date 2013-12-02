package com.cars;

import java.util.List;

import com.cars.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class CustomListViewAdapter extends ArrayAdapter<RowItem> {
 
    Context context;
 
    public CustomListViewAdapter(Context context, int resourceId,
            List<RowItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }
 
    /*private view holder class*/
    private class ViewHolder {
        ImageView image1;
        TextView name, brand, price, mileage, engCapacity,
		noOfCylinders, valves, maxPower, maxTorque, fuelType, gndClearance,
		powSteering, adjSteering, seatingCapacity, abs, transmissionType,
		noOfAirbags, alloyWheels, bodyStyle, bluetooth, colors,
		electricOVRM, fogLights, powerWindows, rearAC, rearWiper;
        
        
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        RowItem rowItem = getItem(position);
 
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.searchdata, null);
            holder = new ViewHolder();
            
            holder.name  = (TextView) convertView.findViewById(R.id.name);
            holder.brand  = (TextView) convertView.findViewById(R.id.brand);
            holder.price  = (TextView) convertView.findViewById(R.id.price);
            holder.mileage  = (TextView) convertView.findViewById(R.id.mileage);
            holder.engCapacity  = (TextView) convertView.findViewById(R.id.engCapacity);
            holder.noOfCylinders  = (TextView) convertView.findViewById(R.id.noOfCylinders);
            holder.valves  = (TextView) convertView.findViewById(R.id.valves);
            holder.maxPower  = (TextView) convertView.findViewById(R.id.maxPower);
            holder.maxTorque  = (TextView) convertView.findViewById(R.id.maxTorque);
            holder.fuelType  = (TextView) convertView.findViewById(R.id.fuelType);
            holder.gndClearance  = (TextView) convertView.findViewById(R.id.gndClearance);
            holder.powSteering  = (TextView) convertView.findViewById(R.id.powSteering);
            holder.adjSteering  = (TextView) convertView.findViewById(R.id.adjSteering);
            holder.seatingCapacity  = (TextView) convertView.findViewById(R.id.seatingCapacity);
            holder.abs  = (TextView) convertView.findViewById(R.id.abs);
            holder.transmissionType  = (TextView) convertView.findViewById(R.id.transmissionType);
            holder.noOfAirbags  = (TextView) convertView.findViewById(R.id.noOfAirbags);
            holder.alloyWheels  = (TextView) convertView.findViewById(R.id.alloyWheels);
            holder.bodyStyle  = (TextView) convertView.findViewById(R.id.bodyStyle);
            holder.bluetooth  = (TextView) convertView.findViewById(R.id.bluetooth);
            holder.colors  = (TextView) convertView.findViewById(R.id.colors);
            holder.electricOVRM  = (TextView) convertView.findViewById(R.id.electricOVRM);
            holder.fogLights  = (TextView) convertView.findViewById(R.id.fogLights);
            holder.powerWindows  = (TextView) convertView.findViewById(R.id.powerWindows);
            holder.rearAC  = (TextView) convertView.findViewById(R.id.rearAC);
            holder.rearWiper  = (TextView) convertView.findViewById(R.id.rearWiper);
            
            
            holder.image1 = (ImageView) convertView.findViewById(R.id.imageView7);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        
        holder.name.setText(rowItem.getName());
        holder.brand.setText(rowItem.getBrand());
        holder.price.setText(rowItem.getPrice());
        holder.mileage.setText(rowItem.getMileage());
        holder.engCapacity.setText(rowItem.getEngCapacity());
        holder.noOfCylinders.setText(rowItem.getNoOfCylinders());
        holder.valves.setText(rowItem.getValves());
        holder.maxPower.setText(rowItem.getMaxPower());
        holder.maxTorque.setText(rowItem.getMaxTorque());
        holder.fuelType.setText(rowItem.getFuelType());
        holder.gndClearance.setText(rowItem.getGndClearance());
        holder.powSteering.setText(rowItem.getPowSteering());
        holder.adjSteering.setText(rowItem.getAdjSteering());
        holder.seatingCapacity.setText(rowItem.getSeatingCapacity());
        holder.abs.setText(rowItem.getAbs());
        holder.transmissionType.setText(rowItem.getTransmissionType());
        holder.noOfAirbags.setText(rowItem.getNoOfAirbags());
        holder.alloyWheels.setText(rowItem.getAlloyWheels());
        holder.bodyStyle.setText(rowItem.getBodyStyle());
        holder.bluetooth.setText(rowItem.getBluetooth());
        holder.colors.setText(rowItem.getColors());
        holder.electricOVRM.setText(rowItem.getElectricOVRM());
        holder.fogLights.setText(rowItem.getFogLights());
        holder.powerWindows.setText(rowItem.getPowerWindows());
        holder.rearAC.setText(rowItem.getRearAC());
        holder.rearWiper.setText(rowItem.getRearWiper());
        
        
        holder.image1.setImageBitmap(rowItem.getImageId());
 
        return convertView;
    }
}