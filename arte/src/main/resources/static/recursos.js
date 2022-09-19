

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


const instance = basicScroll.create({
    elem: document.querySelector('.box'),
    from: 'bottom-bottom',
    to: 'top-top',
    direct: true,
    props: {
       '--r': {
          from: '0',
          to: '1turn'
       },
       '--tx': {
          from: '-100px',
          to: '100px'
       }
    }
 })
 
 instance.start()