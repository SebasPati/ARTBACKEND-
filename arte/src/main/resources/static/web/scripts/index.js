const app = Vue.createApp({
    data() {
        return {
            tema: '',
            activeModal: false,

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
        }
    },
    created() {
        this.initialTheme();
        this.getClients();
        this.getProducts()
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
            if (this.termsOfServiceChecked == false) {
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
                    window.alert("Successful login")
                    this.user = "authenticated"

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
                    console.log(this.clients)
                    console.log(this.artists)
                    console.log(this.arrayArtists1)
                    console.log(this.arrayArtists2)
                    console.log(this.arrayArtists3)
                })
                .catch((error) => console.log(error))
        },
        getProducts() {
            axios.get('/api/products')
                .then((response) => {
                    console.log(response.data)
                    this.products = response.data
                    this.product1 = this.products.slice(0, 1)
                    console.log(this.product1)
                })
                .catch((error) => console.log(error))
        }
    },
    computed: {
    }
}).mount('#app')