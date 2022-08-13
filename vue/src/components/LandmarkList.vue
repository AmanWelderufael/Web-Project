<template>
  <div class = "">
    <!-- <div class="ribbon">

    </div> -->
      
      <the-landmark class = "card" v-bind:landmark ="landmark" v-for="landmark in filteredLandmarks" v-bind:key="landmark.landmark_id"> {{landmark.landmark_description}}</the-landmark>
      

  </div>
</template>

<script>

import LandmarkService from "../services/LandmarkService"
import TheLandmark from './TheLandmark.vue';
export default {

  props:{
    filteredLandmarks: Array
  },
  
  components: { TheLandmark },
    data(){
        return{
              landmarks: []
        }
      

    },

    created() {

    LandmarkService.search().then( response => {
       this.landmarks = response.data;
    })

  },
};
</script>

<style scoped>
*{
  background-color: #112740;
}
  div{
    display: flex;
   flex-wrap: wrap;
   justify-content: space-around;
    
  }
  .card{
    margin-top: 1%;
    margin-bottom: 2%;
    flex: 0 1 32%;
  }
.ribbon{
  position: absolute;
  width: 280px;
  height: 50px;
  background: #af43f1;
}


</style>
