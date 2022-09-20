const { createApp } = Vue
createApp({
  data() {
    return {
      user: 'visitor',
      tema: '',
      prueba: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    }
  },
  created() {
    this.getCurrentClient();
    this.getProducts();
    console.log(this.user);
  },
  methods: {
    getProducts() {
      axios.get('/api/products')
          .then((response) => {
              this.products = response.data
              console.log(this.products)
              this.ej = this.products[0]
              console.log(this.products[0])
              this.product1 = this.products.slice(0, 1)
              this.galleryImage1 = this.product1[0].image
              /* de los productos, traerme un array con cada nombre de cada productos*/
              this.arrayDeImagenes = this.products.map((product) => product.image)
              this.img1 = bg-[url('${this.arrayDeImagenes[0]}')]
              this.img2 = bg-[url('${this.arrayDeImagenes[1]}')]
              this.img3 = bg-[url('${this.arrayDeImagenes[2]}')]
              this.img4 = bg-[url('${this.arrayDeImagenes[3]}')]
              this.img5 = bg-[url('${this.arrayDeImagenes[4]}')]
              this.img6 = bg-[url('${this.arrayDeImagenes[5]}')]
          })
          .catch((error) => console.log(error))
  },
    getCurrentClient() {
      axios.get('/api/clients/current')
        .then((response) => console.log(response.data))
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
  }
}).mount('#app')