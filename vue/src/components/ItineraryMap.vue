<template>
  <div v-if="coordinates.length > 0" class="movie_card" id="bright">
    <GmapMap  id="map" :center="startingCoordinates" :zoom="11" map-type-id="terrain">
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

        let sumOfLatitude = 0;
        let sumOfLongitude = 0;
        for (let i = 0; i < this.landmarks.length; i++) {
          sumOfLatitude = sumOfLatitude + this.landmarks[i].latitude;
          sumOfLongitude = sumOfLongitude + this.landmarks[i].longitude;
          let coordinate = {
            lat: this.landmarks[i].latitude,
            lng: this.landmarks[i].longitude,
          };
          console.log(coordinate);
          this.coordinates.push(coordinate);
        }
        this.startingCoordinates.lat = sumOfLatitude/this.landmarks.length;
        this.startingCoordinates.lng = sumOfLongitude/this.landmarks.length;
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
  height: 350px;
  background-color: rgb(201, 174, 174);
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