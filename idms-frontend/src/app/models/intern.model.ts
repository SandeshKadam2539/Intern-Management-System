export type IdCardType = 'FREE' | 'PREMIUM';

export interface InternRequest {
  name: string;
  email: string;
  mobile: string;
  idCardType: IdCardType;
  dateOfJoining: string; // yyyy-MM-dd
  batchId: number;
}

export interface InternResponse {
  id?: number;
  internId?: string;
  name: string;
  email: string;
  mobile: string;
  idCardType: IdCardType;
  dateOfJoining: string;
  batchId?: number;
  batchLabel?: string;
}
