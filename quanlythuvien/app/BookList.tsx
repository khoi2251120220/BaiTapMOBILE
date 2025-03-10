import React from "react";
import { View, Text, FlatList, StyleSheet } from "react-native";

const books = [
  { id: "1", title: "Sách A", author: "Tác giả A" },
  { id: "2", title: "Sách B", author: "Tác giả B" },
  { id: "3", title: "Sách C", author: "Tác giả C" },
];

export default function BookList() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>📚 Danh sách sách</Text>
      <FlatList
        data={books}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <View style={styles.item}>
            <Text>{item.title} - {item.author}</Text>
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20 },
  title: { fontSize: 18, fontWeight: "bold" },
  item: { padding: 10, borderBottomWidth: 1, borderColor: "#ccc" },
});
