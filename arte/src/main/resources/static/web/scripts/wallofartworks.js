const { createApp } = Vue
createApp({
  data() {
    return {
      user: 'visitor',
      tema: '',
      activeModal: false,
      products: [],
      productDetail: [],
      categories: [],
      categoriesFilter: [],
      categoriesSelect: [],
      nombre: "",
      productsFilter:[]
    }
  },
  created() {
    this.getCurrentClient();
    this.getProducts();
    this.initialTheme();
    console.log(this.user);
    this.currency = this.function
  },
  mounted(){
    this.addClassY('navbar', 50, 'glass1', 'A');
  },
  methods: {
    getProducts() {
      axios.get('/api/products')
        .then((response) => {
          this.products = response.data
          this.productsFilter = this.products
          console.log(this.products)
          this.categories = this.products.map(product => product.category)
          for(var i = 0; i < this.categories.length; i++) {
            const elemento = this.categories[i];
            if (!this.categoriesFilter.includes(this.categories[i])) {
              this.categoriesFilter.push(elemento);
            }
          }
          console.log(this.categoriesFilter);
          // this.ej = this.products[0]
          // console.log(this.products[0])
          // this.product1 = this.products.slice(0, 1)
          // this.galleryImage1 = this.product1[0].image
          // /* de los productos, traerme un array con cada nombre de cada productos*/
          // this.arrayDeImagenes = this.products.map((product) => product.image)
          // this.img1 = bg - [url('${this.arrayDeImagenes[0]}')]
          // this.img2 = bg - [url('${this.arrayDeImagenes[1]}')]
          // this.img3 = bg - [url('${this.arrayDeImagenes[2]}')]
          // this.img4 = bg - [url('${this.arrayDeImagenes[3]}')]
          // this.img5 = bg - [url('${this.arrayDeImagenes[4]}')]
          // this.img6 = bg - [url('${this.arrayDeImagenes[5]}')]
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
    addClassY(ref, yTrigger, classToAdd, classToRemove) {
      const element = eval(`this.$refs.${ref}`);
      window.addEventListener("scroll", () => {
        if (window.scrollY > yTrigger) {
          element.classList.add(classToAdd);
          element.classList.remove(classToRemove);
        } else {
          element.classList.remove(classToAdd);
          element.classList.add(classToRemove);
        }
      })
    },
    function(number){
      return new Intl.NumberFormat('en-US', {style: 'currency',currency: 'USD', minimumFractionDigits: 2}).format(number);
    },
    filtrarPorNombre(products){
      this.productsFilter = products.filter(product =>
      (product.name.toLowerCase().includes(this.nombre.toLowerCase()) |  product.artistName.toLowerCase().includes(this.nombre.toLowerCase()) | product.artistLastName.toLowerCase().includes(this.nombre.toLowerCase())) );
    },
  },
  computed:{
    buscador(){
      if(this.categoriesSelect.length != 0){
        this.productsFilter = this.products.filter(product =>{ 
        return this.categoriesSelect.includes(product.category)})

      }else{
          this.productsFilter = this.products
      }
      if(this.nombre != ''){
        this.filtrarPorNombre(this.productsFilter)
      }
    }
  }
}).mount('#app')