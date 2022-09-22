const { createApp } = Vue
createApp({
  data() {
    return {
      user : 'visitor',
      tema : '',
      articuloCarrito: [],
      products:[],
      carProducts:[],
      numero: 0,
      marketingProducts: []
    }
  },
  created(){
    
    this.currency = this.function
    this.getCart();
    this.getProducts();
    this.getCurrentClient();
    console.log(this.user);
  },
  methods :{
    getCurrentClient(){
    axios.get('/api/clients/current')
                  .then((response) => console.log(response.data )) 
                },
    theme(a) {
        this.tema = `tema_${a}`;
        localStorage.setItem('theme', JSON.stringify(a));
        },
        initialTheme() {
            if (JSON.parse(localStorage.getItem('theme'))) {
                this.theme(JSON.parse(localStorage.getItem('theme')))
                }
            },
    function(number){
      return new Intl.NumberFormat('en-US', {style: 'currency',currency: 'USD', minimumFractionDigits: 2}).format(number);
    },
    getCart(){
      this.articuloCarrito = JSON.parse(localStorage.getItem('articulos'))
      console.log(this.articuloCarrito);
    },
    getProducts(){
      axios.get("/api/products")
      .then(response => {
        this.products = response.data
        this.numero = this.products.length
        this.marketing()
        let indices = this.articuloCarrito.map(articulo => articulo.id)
        let cantidades = this.articuloCarrito.map(articulo => articulo.cantidad)
        for (let i = 0; i < indices.length; i++) {
          let indice = indices[i]
          let cantidad = cantidades[i]
          console.log(indice);
          for (let j = 0; j < this.products.length; j++) {
            if(this.products[j].id == indice){
              this.products[j].cantidad = cantidad
              this.carProducts.push(this.products[j])
            }
          }
        }
      }).catch(error =>{
        console.log(error);
      })
      console.log(this.carProducts);
      
    },
    sumarArticulo(idArticulo) {
      this.articuloCarrito = JSON.parse(localStorage.getItem('articulos'))
      console.log(this.articuloCarrito);
      index = this.articuloCarrito.findIndex(articulo => articulo.id == idArticulo)
      if ((this.articuloCarrito[index].cantidad + 1) <= this.articuloCarrito[index].stock) {
        this.articuloCarrito[index].cantidad += 1
        this.carProducts[index].cantidad = this.articuloCarrito[index].cantidad
      } else {
        console.log("no");
      }
      localStorage.setItem('articulos', JSON.stringify(this.articuloCarrito))
      
    },
    restarArticulo(idArticulo) {
      
      this.articuloCarrito = JSON.parse(localStorage.getItem('articulos'))
      index = this.articuloCarrito.findIndex(articulo => articulo.id == idArticulo)
      if ((this.articuloCarrito[index].cantidad) > 1) {
        this.articuloCarrito[index].cantidad -= 1
        this.carProducts[index].cantidad = this.articuloCarrito[index].cantidad
      } else {
        this.articuloCarrito = this.articuloCarrito.filter(articulo => articulo.id != idArticulo)
        this.carProducts[index].cantidad = 0
        this.carProducts = this.carProducts.filter(product => product != this.carProducts[index])
      }
      localStorage.setItem('articulos', JSON.stringify(this.articuloCarrito))
    },
    eliminarArticulo(idArticulo){
      this.articuloCarrito = JSON.parse(localStorage.getItem('articulos'))
      index = this.articuloCarrito.findIndex(articulo => articulo.id == idArticulo)
      this.articuloCarrito = this.articuloCarrito.filter(articulo => articulo.id != idArticulo)
      this.carProducts[index].cantidad = 0
      this.carProducts = this.carProducts.filter(product => product != this.carProducts[index])
      localStorage.setItem('articulos', JSON.stringify(this.articuloCarrito))
    },
    marketing(){
      function getRandomInt(max) {
        return Math.floor(Math.random() * max);
      }
      let numeros = []
      var cantidadNumeros = 4;
      while(numeros.length < cantidadNumeros ){
        var numeroAleatorio = Math.ceil(getRandomInt(this.numero));
        var existe = false;
        for(var i=0;i< numeros.length;i++){
        if(numeros [i] == numeroAleatorio){
              existe = true;
              break;
          }
        }
        if(!existe){
          numeros[numeros.length] = numeroAleatorio;
        }

      }

      console.log(numeros);
      for (let i = 0; i < numeros.length; i++) {
        this.marketingProducts.push(this.products[numeros[i]])
      }
      console.log(this.marketingProducts);
    }

  }
}).mount('#app')