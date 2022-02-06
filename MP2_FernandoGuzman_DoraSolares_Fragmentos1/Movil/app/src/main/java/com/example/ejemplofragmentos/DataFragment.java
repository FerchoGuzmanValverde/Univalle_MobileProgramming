package com.example.ejemplofragmentos;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    //atributos
    private EditText _editTextTexto;
    private SeekBar _seekBar;
    private Button _btnSend;
    private static int _seekBarValue=10;
    private String _color;
    private DataListener _callback;
    private RadioGroup _radioGroupColor;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            _callback=(DataListener)context;
        }catch(Exception ex){
            throw new ClassCastException(context.toString()+"Deberia implementar un DataListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        _editTextTexto=view.findViewById(R.id.editTextTexto);
        _btnSend=view.findViewById(R.id.buttonSend);
        _seekBar=view.findViewById(R.id.seekBarSize);
        _radioGroupColor=view.findViewById(R.id.radioGroupColor);

        _radioGroupColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                doOnColorChanged(group, checkedId);
            }
        });

        _seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                _seekBarValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        _btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(_color == null)
                     _color = "#ff0000";

                 _callback.sendData(_editTextTexto.getText().toString(), _seekBarValue, _color);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private  void doOnColorChanged(RadioGroup group, int checkedId){
        int checkedRadioId=group.getCheckedRadioButtonId();

        if(checkedRadioId==R.id.radioButtonRojo){
            _color="#ff0000";
            Toast.makeText(getView().getContext(),"Rojo",Toast.LENGTH_SHORT).show();
        }
        else if(checkedRadioId==R.id.radioButtonAzul){
            _color="#3b83bd";
            Toast.makeText(getView().getContext(),"Azul",Toast.LENGTH_SHORT).show();
        }
        else if(checkedRadioId==R.id.radioButtonVerde){
            _color="#008f39";
            Toast.makeText(getView().getContext(),"Verde",Toast.LENGTH_SHORT).show();
        }
    }

}
