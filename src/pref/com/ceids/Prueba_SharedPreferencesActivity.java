package pref.com.ceids;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Prueba_SharedPreferencesActivity extends Activity {
	
	private final String TAG = getClass().getSimpleName();
	
	private TextView tv_lectura;
	private EditText et_texto;
	
	//Clase para manejar base de datos NOSQL
	
	private SharedPreferences spref;
	private Editor spEditor;
	
	//La llave del dato 
	
	private String keyName = "texto";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Referenciar componentes
        
        this.tv_lectura = (TextView) findViewById(R.id.tv_lectura);
        this.et_texto = (EditText) findViewById(R.id.et_texto);
        
        //Obtener el SharedPreferences de la aplicación, si no existe, se crea uno
        
        this.spref = this.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        
        //Obtener el editor de sharedPreferences
        
        this.spEditor = this.spref.edit();
        
        
    }
    
    
    public void guardar(View v){
    	
    	Log.v(TAG, "Estoy en escribir");
    	
    	this.spEditor.putString(keyName, et_texto.getText().toString());
    	
    	this.spEditor.commit();
    	
    }
    
    public void leer(View v){
    	
    	Log.v(TAG, "Estoy en leer");
    	
    	this.tv_lectura.setText("Lectura: "+
    	
    	this.spref.getString(keyName, " - ") ) ;
    	
    }
    
    public void borrar(View v){
    	
    	Log.v(TAG, "Estoy en borrar");
    	
    	
    	this.spEditor.remove(keyName);
    	
    	this.spEditor.commit();
    	
    }
    
    
}