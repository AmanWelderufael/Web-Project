<template>
  <div class="content-cards">
    <div class="card">
      <h1>{{ itinerary.itinerary_name }}</h1>
      <div v-for="landmark in landmarks" v-bind:key="landmark.landmark_id">
      <p>{{ landmark.landmark_name }}</p>
      <button @click="removeLandmark(landmark.landmark_id)"> X </button>
      </div>
      <button @click="deleteItinerary()">Delete this trip</button>
    </div>
  </div>
</template>

<script>
import ItineraryService from '../services/ItineraryService';

import LandmarkService from '../services/LandmarkService';

export default {
  props: {
    itinerary: Object,
  },
  data() {
    return {
      landmarks: [],
    };
  },

  mounted() {
    LandmarkService
      .getByItinerary(this.itinerary.itinerary_id)
      .then((response) => {
        this.landmarks = response.data;
      });
  },
  methods:{
    removeLandmark(landmark_id){
      ItineraryService.removeLandmark(this.itinerary.itinerary_id, landmark_id);
       location.reload();
    },
    deleteItinerary(){
      ItineraryService.deleteItinerary(this.itinerary.itinerary_id);
       location.reload();
    }
  }
};
</script>

<style scoped>
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
  width: auto;
  height: 80%;
  overflow: auto;
}
.card:hover {
  transform: rotate(3deg);
  cursor: pointer;
  transition-duration: 0.5s;
}
</style>