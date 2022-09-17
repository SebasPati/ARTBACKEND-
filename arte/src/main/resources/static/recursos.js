
const app = Vue.createApp({
    data() {
        return {
            tema: '',
        }
    },
    created() {
        this.initialTheme();
    },
    mounted() {
    },
    methods: {
        theme(a){
            this.tema = `tema_${a}`;
            localStorage.setItem('theme', JSON.stringify(a));
        },
        initialTheme(){
            if(JSON.parse(localStorage.getItem('theme'))){
                this.theme(JSON.parse(localStorage.getItem('theme')))
            }
        },
    },
    computed: {
    }
}).mount('#app')