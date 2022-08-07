<template>
  <div>
      <the-landmark v-bind:landmark ="landmark" v-for="landmark in landmarks" v-bind:key="landmark.landmark_id"> {{landmark.landmark_description}}</the-landmark>


  </div>
</template>

<script>

import LandmarkService from "../services/LandmarkService"
import TheLandmark from './TheLandmark.vue';
export default {
  
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

<style>
</style>