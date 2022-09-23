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
            user: '',
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
            profileInfo: "",
            profileImage: "",
            file: '',
            menuPhoto: false,
            modalUploadPhoto: false,
            changeImage: false
        }
    },
    created() {
        this.initialTheme();
        this.getClients();
        this.getProducts();
        this.initialTheme();
        this.getClients();
        this.getProducts();
        this.getCurrentClient();
        /* localStorage.setItem("user","visitor"); */
    },
    mounted() {
        this.addClassY('navbar', 60, 'glass1', 'A');
    },
    methods: {
        theme(a) {
            this.tema = `tema_${a}`;
            if(parseInt(a)>6){
                this.tema = 'tema_1';
            }
            if(a.lenght==0){
                this.tema = 'tema_1'
            }
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
            e.preventDefault()
            console.log(this.login)
            axios.post(`/api/login?email=${this.login.email}&password=${this.login.password}`)
                .then((response) => {
                    this.modalSimple = true
                    this.activeModal = false
                    this.getCurrentClient()
                    localStorage.setItem("user", "authenticated")
                    this.user = localStorage.getItem("user")
                }).catch((error) => {
                    this.mjeError = 'Wrong email or password'
                    console.log(error)
                })
        },
        logout() {
            axios.post('/api/logout').then((response) => this.user = "visitor")
            localStorage.setItem("user", "visitor")
            this.user = localStorage.getItem("user")
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
                    this.product1 = this.products.slice(0, 1)
                    this.galleryImage1 = this.product1[0].image
                    this.arrayDeImagenes = this.products.map((product) => product.image)
                    this.img1 = `bg-[url('${this.arrayDeImagenes[0]}')]`
                    this.img2 = `bg-[url('${this.arrayDeImagenes[1]}')]`
                    this.img3 = `bg-[url('${this.arrayDeImagenes[2]}')]`
                    this.img4 = `bg-[url('${this.arrayDeImagenes[3]}')]`
                    this.img5 = `bg-[url('${this.arrayDeImagenes[4]}')]`
                    this.img6 = `bg-[url('${this.arrayDeImagenes[5]}')]`
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
                .then((response) => {
                    console.log(response.data)
                    this.profileInfo = response.data
                    this.profileImage = this.profileInfo.image
                    console.log(this.profileImage)
                    this.user = localStorage.getItem("user")
                })
                .catch((error)=>{
                    localStorage.setItem("user","visitor")
                })
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
        select_file(event) {
            this.file = event.target.files[0]
            console.log(this.file)
        },
        editPhoto(e){
            e.preventDefault(); 
            let formData = new FormData()
            formData.append("files", this.file)
            axios.post('/api/files/upload/client',
                formData,
                { headers: { 'content-type': 'multipart/form-data' } })
                .then(response => {
                    location.reload()
                })
                .catch(error => alert(error.response.data))    
        },
        prueba() {
            numero = parseInt(this.tema.slice(-1)) + 1
            if (numero >= 7) {
                this.tema = "tema1"
                numero = 1
            } else {
                this.tema = `tema${numero}`
            }
            localStorage.setItem('theme', JSON.stringify(numero));
            this.initialTheme();
        },
    },
    computed: {
    }
}).mount('#app')


/* Para BannerA (Trasladar en Y)*/
document.querySelectorAll('.bannerA').forEach(element => {
    const bannerAy = element.getAttribute('data-mod-y');
    console.log(bannerAy);
    const bannerA = basicScroll.create({
        elem: element,
        from: 'top-middle',
        to: 'bottom-middle',
        direct: true,
        props: {
            '--bannerA-translateY': {
                from: '0',
                to: `${10 * bannerAy}px`
            }
        }
    }).start();
});

/* Para BannerA (Trasladar en X)*/
document.querySelectorAll('.bannerB').forEach(element => {
    const bannerBx = element.getAttribute('data-mod-x');
    console.log(bannerBx);
    const bannerB = basicScroll.create({
        elem: element,
        from: 'top-middle',
        to: 'bottom-middle',
        direct: true,
        props: {
            '--bannerB-translateX': {
                from: '0',
                to: `${10 * bannerBx}px`
            }
        }
    }).start();
});

/* Para fadein */
/* document.querySelectorAll('.fadeIn').forEach(element=>{
    const fadeIn = element.ge
}) */
const fadeIn = basicScroll.create({
    elem: document.querySelector('.fadeIn'),
    from: 'bottom-bottom',
    to: 'top-top',
    props: {
      '--opacidad': {
        from: .01,
        to: .99
      }
    }
  }).start()
