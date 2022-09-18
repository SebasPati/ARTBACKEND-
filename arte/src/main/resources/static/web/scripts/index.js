const app = Vue.createApp({
    data() {
        return {
            tema: '',
            activeModal: "no",

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
        }
    },
    created() {
        this.initialTheme();
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

        /* PROPIOS DE LA PAG */
        createAccount() {
            this.mjeError = ''
            console.log(this.register)
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
                    .then((response) => this.modal = 'login')
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
        }
    },
    computed: {
    }
}).mount('#app')