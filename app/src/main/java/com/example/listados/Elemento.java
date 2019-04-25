package com.example.listados;

/*

{
    "texto": "estudiar",
	"imagen": 1,
	"imagen1": 2

}
 */


import com.google.gson.Gson;

public class Elemento {

    public String texto;
    public int imagen;
    public int imagen1;

    public Elemento(String texto, int imagen, int imagen1) {
        this.texto = texto;
        this.imagen = imagen;
        this.imagen1 = imagen1;
    }


    public String toJson() {

        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

}

