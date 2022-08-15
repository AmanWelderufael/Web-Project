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
  position: relative;
  display: block;
  width: 800px;
  height: 350px;
  margin: 80px auto;
  overflow: hidden;
  border-radius: 10px;
  transition: all 0.4s;
  box-shadow: 0px 0px 120px -25px rgba(0, 0, 0, 0.5);
}
#map {
  width: 100%;
  height: 100%;
}
</style>