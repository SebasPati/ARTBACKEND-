const app = Vue.createApp({
    data() {
        return {
            tema: '',
            activeModal: false,
            modalSimple: false,
            modalDetails: true,
            productSelected: "",
            productSelectedimg: "",
            goTo: "",
            location: "",
            modal: "",
            login: {
                email: "",
                password: ""
            },
            register: {
                name: '',
                lastName: '',
                email: '',
                password: ''
            },
            repeatedPassword: '',
            mjeError: "",
            termsOfServiceChecked: "",
            userType: '',
            user: "visitor",
            artists: [],
            arrayArtists1: [],
            arrayArtists2: [],
            arrayArtists3: [],
            products: [],
            preduct1: {},
            galleryImage1: "",
            arrayDeImagenes: [],
            img1: "",
            img2: "",
            img3: "",
            img4: "",
            img5: "",
            img6: "",
            artistsOrderedByRanking: {},
            bestArtist: {},
            ej: {},
        }
    },
    created() {
        this.initialTheme();
        this.getClients();
        this.getProducts();
        this.getCurrentClient()

    },
    mounted() {
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

        /* REQUESTS */
        createAccount() {
            this.mjeError = ''
            console.log(this.register)
            console.log(this.userType)
            if (this.register.password != this.repeatedPassword) {
                this.mjeError = "The passwords are not the same"
            }
            else if (this.termsOfServiceChecked == false) {
                this.mjeError = "You must agree the Terms of Service"
            }
            else {
                axios.post('/api/clients', {
                    "name": this.register.name,
                    "lastName": this.register.lastName,
                    "password": this.register.password,
                    "email": this.register.email,
                    "typeUser": this.userType
                })
                    .then((response) => {
                        this.modal = 'login'
                        console.log('registrado')
                    })
                    .catch((error) => {
                        this.mjeError = error.response.data

                    })
            }


        },
        loginAccount(e) {
            e.preventDefault()/* window.location.href = "/web/public/wallofartist.html" */
            console.log(this.login)
            axios.post(`/api/login?email=${this.login.email}&password=${this.login.password}`)
                .then((response) => {
                    this.user = "authenticated"

                    this.modalSimple = true
                    this.activeModal = false

                }).catch((error) => {
                    this.mjeError = 'Wrong email or password'
                    console.log(error)
                })
        },
        logout() {
            axios.post('/api/logout').then((response) => this.user = "visitor")
        },
        getClients() {
            axios.get('api/clients')
                .then((response) => {
                    this.clients = response.data
                    this.artists = response.data.filter((client) => client.typeUser == "ARTIST")
                    this.arrayArtists1 = this.artists.slice(0, 3)
                    this.arrayArtists2 = this.artists.slice(3, 6)
                    this.arrayArtists3 = this.artists.slice(6, 9)
                    /* console.log(this.clients) */
                    console.log(this.artists)
                    this.artistsOrderedByRanking = this.artists.sort((a, b) => (a.ranking < b.ranking) ? 1 : -1)
                    this.bestArtist = this.artistsOrderedByRanking[0]
                })
                .catch((error) => console.log(error))
        },
        getProducts() {
            axios.get('/api/products')
                .then((response) => {
                    /* console.log(response.data) */
                    this.products = response.data
                    console.log(this.products)
                    this.ej = this.products[0]
                    console.log(this.products[0])
                    this.product1 = this.products.slice(0, 1)
                    this.galleryImage1 = this.product1[0].image
                    this.arrayDeImagenes = this.products.map((product) => product.image)
                    this.img1 = `bg-[url('${this.arrayDeImagenes[0]}')]`
                    this.img2 = `bg-[url('${this.arrayDeImagenes[1]}')]`
                    this.img3 = `bg-[url('${this.arrayDeImagenes[2]}')]`
                    this.img4 = `bg-[url('${this.arrayDeImagenes[3]}')]`
                    this.img5 = `bg-[url('${this.arrayDeImagenes[4]}')]`
                    this.img6 = `bg-[url('${this.arrayDeImagenes[5]}')]`
                    console.log(this.img2)
                    console.log(this.arrayDeImagenes)
                })
                .catch((error) => console.log(error))
        },
        Redirect() {

            if (this.goTo == 'Store') { this.location = "/web/public/wallofartworks.html" }
            if (this.goTo == 'Profile') { this.location = "/web/artistandartlovers/myprofile.html" }
            console.log(this.location)

            window.location.href = this.location
        },
        getCurrentClient() {
            axios.get('/api/clients/current')
                .then((response) => console.log(response.data))
        },
        modifyProductSelected(item) {
            this.productSelected = item
            this.productSelectedimg = this.productSelected.image.toString()
            let selectUnits = document.getElementById("selectUnits");
            let child = ""
            for (i = 1; i < this.productSelected.units + 1; i++) {
                child += `<option>${i}</option>`
            }
            selectUnits.innerHTML = child

        }
    },
    computed: {
    }
}).mount('#app')