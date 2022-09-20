

const app = Vue.createApp({
    data() {
        return {
            tema: '',
            artist: [],
            products: [],
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

    },
    computed: {
    }
}).mount('#app')