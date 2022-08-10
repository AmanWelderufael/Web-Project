<template>
  <div>
    <div>
      <h5 class="card-title">{{ landmark.landmark_name }}</h5>
      <p id="description" class="card-text">
        {{ landmark.landmark_description }}
      </p>
    </div>
    <the-map v-bind:landmark="landmark" class="gridItem" id="map"></the-map>
  </div>
</template>

<script>
import LandmarkService from "../services/LandmarkService";
import TheMap from "../components/map.vue";

export default {
  name: "itinerary",

  data() {
    return {
      landmark: "",
    };
  },
  components: {
    TheMap,
  },
  created() {
    LandmarkService.getByID(this.$route.params.id).then((response) => {
      this.landmark = response.data;
    });
  },
 
  
};
</script>

<style scoped>
</style>