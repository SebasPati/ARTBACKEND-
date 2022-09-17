const app = Vue.createApp({
    data() {
        return {
            modal: "",
            usertype: '',
            name: '',
            lastName: '',
            email: '',
            password: '',
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
            const request_body = {
                "name": this.name,
                "lastName": this.lastName,
                "email": this.email,
                "password": this.password
            }

            console.log(request_body)
            axios.post('/api/clients', {
                data: {
                    "name": this.name,
                    "lastName": this.lastName,
                    "email": this.email,
                    "password": this.password
                }
            },
                { headers: { 'content-type': 'application/json' } })
                .then(response => console.log("creado"))
                .catch(error => alert(error.response.data))
            /* console.log(this.name, this.lastName, this.email, this.password)
            axios.post('/api/clients', {
                "name": this.name,
                "lastName": this.lastName,
                "email": this.email,
                "password": this.password
            })
                .then((response) => console.log('hecho'))
                .catch((error) => console.log(error.response.data)) */

        }
    },
    computed: {
    }
}).mount('#app')