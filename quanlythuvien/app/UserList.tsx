import React from "react";
import { View, Text, FlatList, StyleSheet } from "react-native";

const users = [
  { id: "1", name: "Nguyễn Văn A" },
  { id: "2", name: "Trần Thị B" },
  { id: "3", name: "Lê Văn C" },
];

export default function UserList() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>👤 Danh sách người dùng</Text>
      <FlatList
        data={users}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <View style={styles.item}>
            <Text>{item.name}</Text>
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
