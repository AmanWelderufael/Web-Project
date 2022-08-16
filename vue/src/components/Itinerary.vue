<template>
  <div class="card">
    <button class="deletebtn" @click="deleteItinerary()">
      Delete this trip
    </button>

    <h2>{{ itinerary.itinerary_name }}</h2>
    <div v-for="landmark in landmarks" v-bind:key="landmark.landmark_id">
      <p>{{ landmark.landmark_name }}  <button class="xbtn" @click="removeLandmark(landmark.landmark_id)">X</button></p>
      
    </div>
    
<!-- <ul>
<li v-for="landmark in landmarks" v-bind:key="landmark.landmark_id">
  <p>{{ landmark.landmark_name }}</p>
  <button class="delete" @click="removeLandmark(landmark.landmark_id)">X</button>
</li>
      </ul> -->
    

    <div class="mapcard">
      <itinerary-map v-bind:itinerary="this.itinerary" />
    </div>
  </div>
</template>

<script>
import ItineraryService from "../services/ItineraryService";

import LandmarkService from "../services/LandmarkService";
import ItineraryMap from "./ItineraryMap.vue";

export default {
  components: { ItineraryMap },
  props: {
    itinerary: Object,
  },
  data() {
    return {
      landmarks: [],
    };
  },

  mounted() {
    LandmarkService.getByItinerary(this.itinerary.itinerary_id).then(
      (response) => {
        this.landmarks = response.data;
      }
    );
  },
  methods: {
    removeLandmark(landmark_id) {
      ItineraryService.removeLandmark(this.itinerary.itinerary_id, landmark_id);
      location.reload();
    },
    deleteItinerary() {
      ItineraryService.deleteItinerary(this.itinerary.itinerary_id);
      location.reload();
    },
  },
};
</script>

<style scoped>
.card {
  background-color: rgba(73, 41, 41, 0.7);
  border-radius: 18px;

  padding: 1em;

  width: 100%;
  position: relative;
}

.deletebtn{
  
 
  color: #fff;
background-color: #112740;
  transition: all 150ms ease-in-out;
  position:absolute;
     top:0;
     right:0;
     margin: 5px;
     border-radius: 10%;
     

}
.deletebtn:hover {
  background-color: #3498db;
   
}

.xbtn{
  float: right;
  
  color: white;
 
  background-color: #e74c3c;
  
  
   height: 25px;
  width: 25px;
 
  border-radius: 50%;
  display: inline-block;
  cursor: pointer;

}




/* .card:hover {
  transform: rotate(3deg);
  cursor: pointer;
  transition-duration: 0.5s;
} */

</style>