package com.example.cruds;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorPacientes extends RecyclerView.Adapter<AdaptadorPacientes.MyViewHolder> {

    private List<Paciente> listaDePacientes;

    public AdaptadorPacientes(List<Paciente> pacientes) {
        this.listaDePacientes = pacientes;
    }

    public void setListaDePacientes(List<Paciente> listaDePacientes) {
        this.listaDePacientes = listaDePacientes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View filaPaciente = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila_paciente, parent, false);
        return new MyViewHolder(filaPaciente);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Paciente paciente = listaDePacientes.get(position);

        holder.nombre.setText(paciente.getNombre());
        holder.edad.setText(String.valueOf(paciente.getEdad()));
        holder.chkInternado.setChecked(paciente.getInternado());
    }

    @Override
    public int getItemCount() {
        return listaDePacientes != null ? listaDePacientes.size() : 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, edad;
        CheckBox chkInternado;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            edad = itemView.findViewById(R.id.tvEdad);
            chkInternado = itemView.findViewById(R.id.cbInternado);
        }
    }
}
