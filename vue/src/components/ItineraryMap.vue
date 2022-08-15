<template>
  <div v-if="coordinates.length > 0" class="movie_card" id="bright">
    <GmapMap  id="map" :center="coordinates[0]" :zoom="16" map-type-id="terrain">
      <GmapMarker
        v-for="coordinate in coordinates"
        v-bind:key="coordinate"
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
  mounted() {
    LandmarkService.getByItinerary(this.itinerary.itinerary_id).then(
      (response) => {
        this.landmarks = response.data;

        for (let i = 0; i < this.landmarks.length; i++) {
          let coordinate = {
            lat: this.landmarks[i].latitude,
            lng: this.landmarks[i].longitude,
          };
          console.log(coordinate);
          this.coordinates.push(coordinate);
        }
      }
    );
  },
};
</script>

<style scoped>
.movie_card {
  position: relative;
  
 width: 100%;
 height: 100%;
  background-color: red;
  overflow: hidden;
  border-radius: 10px;
  transition: all 0.4s;
  box-shadow: 0px 0px 120px -25px rgba(211, 19, 19, 0.5);
  
}
#map {
  width: 100%;
  height: 100%;
}
</style>