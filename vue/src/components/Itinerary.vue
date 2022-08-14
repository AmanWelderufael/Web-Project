<template>
  <div class="content-cards">
    <div
      class="card"
      v-for="itinerary in itineraries"
      v-bind:key="itinerary.itinerary_id"
      v-bind:value="itinerary.itinerary_id"
    >
      {{ itinerary.itinerary_name }}
    </div>
    
  </div>
</template>

<script>
import itineraryService from "../services/ItineraryService";
export default {
  props: {
    landmark: Object,
  },
  data() {
    return {
      itineraries: [],
      selectedItinerary: "",
    };
  },

  created() {
    itineraryService.search().then((response) => {
      this.itineraries = response.data;
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