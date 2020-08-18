
package com.example.rest2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class ModelService2 {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("valor1")
        @Expose
        private String valor1;
        @SerializedName("valor2")
        @Expose
        private String valor2;
        @SerializedName("valor3")
        @Expose
        private String valor3;
        @SerializedName("fecha")
        @Expose
        private String fecha;
        @SerializedName("hora")
        @Expose
        private String hora;
        @SerializedName("servidor")
        @Expose
        private String servidor;

        /**
         * No args constructor for use in serialization
         *
         */
        public ModelService2() {
        }

        /**
         *
         * @param fecha
         * @param servidor
         * @param hora
         * @param valor1
         * @param valor3
         * @param id
         * @param valor2
         */
        public ModelService2(Integer id, String valor1, String valor2, String valor3, String fecha, String hora, String servidor) {
            super();
            this.id = id;
            this.valor1 = valor1;
            this.valor2 = valor2;
            this.valor3 = valor3;
            this.fecha = fecha;
            this.hora = hora;
            this.servidor = servidor;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public ModelService2 withId(Integer id) {
            this.id = id;
            return this;
        }

        public String getValor1() {
            return valor1;
        }

        public void setValor1(String valor1) {
            this.valor1 = valor1;
        }

        public ModelService2 withValor1(String valor1) {
            this.valor1 = valor1;
            return this;
        }

        public String getValor2() {
            return valor2;
        }

        public void setValor2(String valor2) {
            this.valor2 = valor2;
        }

        public ModelService2 withValor2(String valor2) {
            this.valor2 = valor2;
            return this;
        }

        public String getValor3() {
            return valor3;
        }

        public void setValor3(String valor3) {
            this.valor3 = valor3;
        }

        public ModelService2 withValor3(String valor3) {
            this.valor3 = valor3;
            return this;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public ModelService2 withFecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        public String getHora() {
            return hora;
        }

        public void setHora(String hora) {
            this.hora = hora;
        }

        public ModelService2 withHora(String hora) {
            this.hora = hora;
            return this;
        }

        public Object getServidor() {
            return servidor;
        }

        public void setServidor(String servidor) {
            this.servidor = servidor;
        }

        public ModelService2 withServidor(String servidor) {
            this.servidor = servidor;
            return this;
        }

    }