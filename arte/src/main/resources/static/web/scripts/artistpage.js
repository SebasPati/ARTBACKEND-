

const app = Vue.createApp({
    data() {
        return {
            tema: '',
            artist: [],
            products: [],
            formularioProduct: false,
            formulario: false,
            formEdit:{
                name: "",
                description: "",
                price: 0,
                category: "",
                image: [],
                height: 0,
                width: 0,
                large: 0,
                units: 0,
            },
            formLoad:{
                name: "",
                description: "",
                price: 0,
                category: "",
                image: [],
                height: 0,
                width: 0,
                large: 0,
                units: 0,
            },
            Product: {},
        }
    },
    created() {
        this.initialTheme();
        this.loadData();
    },
    mounted() {
        this.vueScrollNav();
    },
    methods: {
        theme(a) {
            this.tema = `tema_${a}`;
            localStorage.setItem('theme', JSON.stringify(a));
        },
        initialTheme() {
            if (JSON.parse(localStorage.getItem('theme'))) {
                this.theme(JSON.parse(localStorage.getItem('theme')))
            }
        },
        vueScrollNav() {
            const navbar = this.$refs.navbar;
            window.addEventListener("scroll", () => {
                if (window.scrollY > 50) {
                    navbar.classList.add("glass1");
                } else {
                    navbar.classList.remove("glass1");
                }
            })
        },
        loadData(){
            const urlParams = new URLSearchParams(window.location.search);
            const Id = urlParams.get('id');
            axios.get(`/api/clients/${Id}`)
            .then(response => {
                this.artist = response.data
                console.log(this.artist)
                this.products = this.artist.products
                console.log(this.products);
            })
        },
        updateProduct(product){
            console.log(product);
            axios.patch(`/api/clients/current/products/update/${product.id}`,{
                "name": this.formEdit.name,
                "description" : this.formEdit.description,
                "category" : this.formEdit.category,
                "dimensionsList" : [this.formEdit.width,this.formEdit.large,this.formEdit.height],
                "image": "https://media.istockphoto.com/photos/adam-picture-id92879541?k=20&m=92879541&s=612x612&w=0&h=Q-Lfu2NI1dwrROrmXkYzke66tVTaWrwMbHBEgJZeJVg=",
                "price" : this.formEdit.price,
                "status": true,
                "units" : this.formEdit.units
            })
            .then(response => {
                console.log("ok");
                location.reload()
            }).catch(error => {
                console.log(error);
            })
        },
        loadProduct(){

            axios.post("/api/clients/current/products",{
                "name": this.formLoad.name,
                "description" : this.formLoad.description,
                "category" : this.formLoad.category,
                "dimensionsList" : [this.formLoad.large,this.formLoad.width,this.formLoad.height],
                "image": "https://media.istockphoto.com/photos/adam-picture-id92879541?k=20&m=92879541&s=612x612&w=0&h=Q-Lfu2NI1dwrROrmXkYzke66tVTaWrwMbHBEgJZeJVg=",
                "price" : this.formLoad.price,
                "status": true,
                "units" : this.formLoad.units
            }).then(response => {
                location.reload()
            }).catch(error => {
                console.log(error);
            })
        }
    },
    computed: {
    }
}).mount('#app')