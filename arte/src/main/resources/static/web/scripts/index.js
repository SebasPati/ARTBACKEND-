const app = Vue.createApp({
    data() {
        return {
            tema: '',
            modal: "",
            usertype: '',
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
            repeatedPassword: ''
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
            console.log(this.register)
            if (this.register.password == this.repeatedPassword) {
                axios.post('/api/clients', {
                    "name": this.register.name,
                    "lastName": this.register.lastName,
                    "password": this.register.password,
                    "email": this.register.email
                })
                    .then((response) => window.location.href = '/web/artistandartlovers/myprofile.html')
                    .catch(() => console.log('error'))
            }
        },
        loginAccount(e) {
            e.preventDefault()
            console.log(this.login)
            axios.post('api/login', this.login)
                .then((response) => window.location.href = '/web/public/wallofartist.html')
                .catch((error) => console.log("error"))
        }
    },
    computed: {
    }
}).mount('#app')