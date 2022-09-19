

const app = Vue.createApp({
    data() {
        return {
            tema: '',
            activeModal: false,
            modalSimple: false
        }
    },
    created() {
        this.initialTheme();
        
    },
    mounted() {
        this.addClassY('navbar',50,'glass1');
        this.changethemesY();
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
        changethemesY(){
            window.addEventListener("scroll",()=>{
                if(window.scrollY>200 && window.scrollY<450){
                    this.theme(1);
                }else if(window.scrollY>450 && window.scrollY<950){
                    this.theme(4);
                }else if(window.scrollY>950){
                    this.theme(3);
                }
            })
        },
        addClassY(ref,yTrigger,classToAdd) {
            const navbar = eval(`this.$refs.${ref}`);
            window.addEventListener("scroll", () => {
                if (window.scrollY > yTrigger) {
                    navbar.classList.add(classToAdd);
                } else {
                    navbar.classList.remove(classToAdd);
                }
            })
        },
        sacarModalSimple(){
            setTimeout(()=>this.changeURL('/index.html'), 1600);
        },
        changeURL(location){
            window.location.href = location;
        }
    },
    computed: {

    }
}).mount('#app')


document.querySelectorAll('.venus').forEach(element => {
    const modx = element.getAttribute('data-mod-x');
    const mody = element.getAttribute('data-mod-y');
    console.log(modx);
    console.log(mody);

    basicScroll.create({
        elem:element,
        from:400,
        to: 800,
        direct: true,
        props:{
            '--translateX':{
                from: '0',
                to: `${10 * modx}px`
            },
            '--translateY':{
                from: '0',
                to: `${10 * mody}px`
            }
        }
    }).start();
});