package com.example.altaproductos.datos;

public class HelperClassAltaCombos {
		private int idCombo;
		private int cantidadProductoComprado;
		private int idProductoComprado;
		private int cantidadProductoRegalo;
		private int idProductoRegalo;
		
		public HelperClassAltaCombos(int idCombo,int cantidadProductoComprado,int idProductoComprado,int cantidadProductoRegalo,int idProductoRegalo) {
			this.idCombo = idCombo;
			this.cantidadProductoComprado = cantidadProductoComprado;
			this.idProductoComprado = idProductoComprado;
			this.cantidadProductoRegalo = cantidadProductoRegalo;
			this.idProductoRegalo = idProductoRegalo;
		}

		public int getIdCombo() {
			return idCombo;
		}

		public void setIdCombo(int idCombo) {
			this.idCombo = idCombo;
		}

		public int getCantidadProductoComprado() {
			return cantidadProductoComprado;
		}

		public void setCantidadProductoComprado(int cantidadProductoComprado) {
			this.cantidadProductoComprado = cantidadProductoComprado;
		}

		public int getIdProductoComprado() {
			return idProductoComprado;
		}

		public void setIdProductoComprado(int idProductoComprado) {
			this.idProductoComprado = idProductoComprado;
		}

		public int getCantidadProductoRegalo() {
			return cantidadProductoRegalo;
		}

		public void setCantidadProductoRegalo(int cantidadProductoRegalo) {
			this.cantidadProductoRegalo = cantidadProductoRegalo;
		}

		public int getIdProductoRegalo() {
			return idProductoRegalo;
		}

		public void setIdProductoRegalo(int idProductoRegalo) {
			this.idProductoRegalo = idProductoRegalo;
		}
		
		
}
