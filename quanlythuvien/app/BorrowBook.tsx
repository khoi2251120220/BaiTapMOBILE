import React, { useState } from "react";
import {View,Text,TextInput,TouchableOpacity,FlatList,StyleSheet,} from "react-native";
import { Checkbox } from "react-native-paper";

const books = ["Sách 01", "Sách 02", "Sách 03", "Sách 04"];

export default function BorrowBook() {
  const [selectedUser, setSelectedUser] = useState("Nguyen Van A");
  const [selectedBooks, setSelectedBooks] = useState<string[]>([]);

  const toggleBookSelection = (book: string) => {
    setSelectedBooks((prev) =>
      prev.includes(book) ? prev.filter((b) => b !== book) : [...prev, book]
    );
  };

  return (
    <View style={styles.container}>
      <Text style={styles.header}>Hệ thống{"\n"}Quản lý Thư viện</Text>

      <Text style={styles.label}>Tên người mượn sách</Text>
      <View style={styles.row}>
        <TextInput
          style={styles.input}
          value={selectedUser}
          onChangeText={setSelectedUser}
        />
        <TouchableOpacity style={styles.button}>
          <Text style={styles.buttonText}>Đổi</Text>
        </TouchableOpacity>
      </View>

      <Text style={styles.label}>Danh sách sách</Text>
      <View style={styles.bookList}>
        <FlatList
          data={books}
          keyExtractor={(item) => item}
          renderItem={({ item }) => (
            <View style={styles.bookItem}>
              <Checkbox
                status={selectedBooks.includes(item) ? "checked" : "unchecked"}
                onPress={() => toggleBookSelection(item)}
              />
              <Text style={styles.bookText}>{item}</Text>
            </View>
          )}
        />
      </View>

      <TouchableOpacity
        style={styles.addButton}
        onPress={() => alert(`${selectedUser} đã mượn: ${selectedBooks.join(", ")}`)}
      >
        <Text style={styles.buttonText}>Thêm</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20, backgroundColor: "#fff" },
  header: { fontSize: 20, fontWeight: "bold", textAlign: "center", marginBottom: 20 },
  label: { fontSize: 16, fontWeight: "bold", marginTop: 10 },
  row: { flexDirection: "row", alignItems: "center", marginBottom: 10 },
  input: {
    flex: 1,
    borderWidth: 1,
    borderColor: "#ccc",
    padding: 8,
    borderRadius: 5,
    marginRight: 10,
  },
  button: { backgroundColor: "#0066CC", padding: 10, borderRadius: 5 },
  buttonText: { color: "#fff", fontWeight: "bold" },
  bookList: {
    backgroundColor: "#ddd",
    padding: 10,
    borderRadius: 10,
    marginBottom: 20,
  },
  bookItem: {
    flexDirection: "row",
    alignItems: "center",
    backgroundColor: "#fff",
    padding: 10,
    borderRadius: 5,
    marginVertical: 5,
  },
  bookText: { marginLeft: 10 },
  addButton: { backgroundColor: "#0066CC", padding: 15, borderRadius: 5, alignItems: "center" },
});

