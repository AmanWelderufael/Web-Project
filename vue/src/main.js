import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import * as VueGoogleMaps from 'vue2-google-maps'
import {library } from '@fortawesome/fontawesome-svg-core'
import { faHatWizard } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyDH7ynsgb80kcNnfE_3tCaF_Wu_JxOtEfA',
    libraries: 'places', 
  },

 
  installComponents: true
})
library.add(faHatWizard)
Vue.component('font-awesome-icon', FontAwesomeIcon)



Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
