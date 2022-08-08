<template>
  <div>
      
      <the-landmark v-bind:landmark ="landmark" v-for="landmark in filteredLandmarks" v-bind:key="landmark.landmark_id"> {{landmark.landmark_description}}</the-landmark>
      

  </div>
</template>

<script>

import LandmarkService from "../services/LandmarkService"
import TheLandmark from './TheLandmark.vue';
export default {

  props:{
    filteredLandmarks: []
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
  div{
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    
  }
  the-landmark{
    flex-grow: 1;
  }



</style>