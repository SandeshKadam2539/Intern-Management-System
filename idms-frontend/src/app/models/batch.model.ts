export interface Batch {
  id?: number;
  startDate: string; // yyyy-MM-dd
  endDate?: string;  // yyyy-MM-dd
  lastSeqNumber?: number;
  internCount?: number;
}
