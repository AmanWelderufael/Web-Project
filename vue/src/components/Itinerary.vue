<template>
  <div class="content-cards">
    <div
      class="card"
    >  <h1>{{ itinerary.itinerary_name }}</h1>
    <p v-for="landmark in landmarks" v-bind:key="landmark.landmark_id"> {{landmark.landmark_name}} </p>
    
    </div>
    
    
  </div>
</template>

<script>

import LandmarkService from "../services/LandmarkService"





export default {
  
  props: {
    itinerary: Object,
  },
  data() {
    return {
      landmarks: []
      
     
     
    };
  },
 


  created() {
    
    
    LandmarkService.getByItinerary(this.itinerary).then((response) => {
      this.landmarks = response.data;
    });
    
    
  },
};
</script>

<style >
.content-cards {
  display: flex;
  padding: 1em;
  gap: 1em;
  height: 100%;
  flex-wrap: wrap;
  justify-content: center;
}

.card {
  background-color: rgba(73, 41, 41, 0.7);
  border-radius: 18px;
  box-shadow: 2px 4px 12px rgb(0 0 0 / 8%);
  padding: 1em;
  position: relative;
  color: rgb(255, 255, 255);
  width: 15em;
  height: 20em;
  overflow: auto;
  
}
.card:hover {
  transform:rotate(3deg);
  cursor: pointer;
  transition-duration: 0.5s;
}

</style>