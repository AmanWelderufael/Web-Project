<template>
  <div class="movie_card" id="bright">
    <GmapMap
      id="map"
      :center="coordinates[1]"
      :zoom="16"
      map-type-id="terrain"
    >
      <GmapMarker v-for="coordinate in coordinates" v-bind:key="coordinate"
        :position="coordinate"
        :clickable="true"
        :draggable="false"
        @click="center = m.position"
      />
    </GmapMap>
  </div>
</template>

<script>
import LandmarkService from "../services/LandmarkService";
export default {
  props: {
    itinerary: Object,
  },
  name: "the-map",
  data() {
    return {
      landmarks: [],
      coordinates: [],
      startingLandmark: "",
      startingCoordinates: {
        lat: "",
        lng: "",
      },
    };
  },
  created() {
    LandmarkService.getByItinerary(this.itinerary.itinerary_id).then(
      (response) => {
        this.landmarks = response.data;
      }
    );
    for (let i = 0; i < this.landmarks.length; i++) {
      this.coordinates[i].lat = this.landmarks[i].latitude;
      this.coordinates[i].lng = this.landmarks[i].longitude;
    }
  },
};
</script>

<style scoped>
.movie_card {
  
 
 
  height: 350px;
  background-color: rgb(201, 174, 174);
  overflow: hidden;
  border-radius: 10px;
  transition: all 0.4s;
  box-shadow: 0px 0px 120px -25px rgba(211, 19, 19, 0.5);
  
}
#map {
  width: 100%;
  
}
</style>