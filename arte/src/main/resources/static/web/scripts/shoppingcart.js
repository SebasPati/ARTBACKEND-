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
      marketingProducts: [],
      itemCarrito:{
        id:0,
        stock:0,
        cantidad:0,
        total:0
      },
      totalPay:0
    }
  },
  created(){
    this.currency = this.function
    this.getCart();
    this.getProducts();
    this.getCurrentClient();
    this.total()
    this.musica()
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
        let price = (this.articuloCarrito[index].total / this.articuloCarrito[index].cantidad)
        this.articuloCarrito[index].cantidad += 1
        this.carProducts[index].cantidad = this.articuloCarrito[index].cantidad
        this.articuloCarrito[index].total = price * this.articuloCarrito[index].cantidad
      } else {
        console.log("no");
      }
      localStorage.setItem('articulos', JSON.stringify(this.articuloCarrito))
      this.total()
    },
    restarArticulo(idArticulo) {
      
      this.articuloCarrito = JSON.parse(localStorage.getItem('articulos'))
      index = this.articuloCarrito.findIndex(articulo => articulo.id == idArticulo)
      if ((this.articuloCarrito[index].cantidad) > 1) {
        let price = (this.articuloCarrito[index].total / this.articuloCarrito[index].cantidad)
        this.articuloCarrito[index].cantidad -= 1
        this.carProducts[index].cantidad = this.articuloCarrito[index].cantidad
        this.articuloCarrito[index].total = price * this.articuloCarrito[index].cantidad
      } else {
        this.articuloCarrito = this.articuloCarrito.filter(articulo => articulo.id != idArticulo)
        this.carProducts[index].cantidad = 0
        this.carProducts = this.carProducts.filter(product => product != this.carProducts[index])
      }
      localStorage.setItem('articulos', JSON.stringify(this.articuloCarrito))
      this.total()
    },
    eliminarArticulo(idArticulo){
      this.articuloCarrito = JSON.parse(localStorage.getItem('articulos'))
      index = this.articuloCarrito.findIndex(articulo => articulo.id == idArticulo)
      this.articuloCarrito = this.articuloCarrito.filter(articulo => articulo.id != idArticulo)
      this.carProducts[index].cantidad = 0
      this.carProducts = this.carProducts.filter(product => product != this.carProducts[index])
      localStorage.setItem('articulos', JSON.stringify(this.articuloCarrito))
      this.total()
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
    },
    escuchadorCarrito(producto) {
      console.log(producto);
      this.articuloCarrito = JSON.parse(localStorage.getItem('articulos'))
      this.itemCarrito.id = producto.id
      this.itemCarrito.stock = producto.units
      this.itemCarrito.total = producto.price
      if (this.articuloCarrito != null) {
        let filter_repeated = this.articuloCarrito.filter(articulo => articulo.id == (producto.id))

        if (filter_repeated.length) {
          this.itemCarrito.id = filter_repeated.id
          this.itemCarrito.stock = filter_repeated.units
          this.itemCarrito.cantidad = filter_repeated.cantidad
          this.itemCarrito.total = filter_repeated.price * filter_repeated.cantidad
          index = this.articuloCarrito.findIndex(articulo => articulo.id == producto.id)

          if (this.articuloCarrito[index].cantidad < this.articuloCarrito[index].stock) {
            this.articuloCarrito[index].cantidad += 1
            this.articuloCarrito[index].total = filter_repeated.price *  this.articuloCarrito[index].cantidad
          }else{
            console.log("no stock");
          }
        } else {
          this.itemCarrito.cantidad = 1
          this.articuloCarrito.push(this.itemCarrito)
        }
        console.log(this.articuloCarrito);
        localStorage.setItem('articulos', JSON.stringify(this.articuloCarrito))
      } else {
        this.articuloCarrito = []
        this.articuloCarrito.push(this.itemCarrito)
        this.cantidad = 1
        console.log(this.articuloCarrito);
        localStorage.setItem('articulos', JSON.stringify(this.articuloCarrito))
        console.log(this.cantidad);
      }
      this.cond=true
      location.reload()
    },
    total(){
      this.totalPay = 0
      this.articuloCarrito = JSON.parse(localStorage.getItem('articulos'))
      for (let i = 0; i < this.articuloCarrito.length; i++) {
        this.totalPay += this.articuloCarrito[i].total 
      }
    },
    musica(){
      setTimeout(function(){
        var vid = document.getElementById('intro')
        vid.play()
      },500)
    }

  }
}).mount('#app')